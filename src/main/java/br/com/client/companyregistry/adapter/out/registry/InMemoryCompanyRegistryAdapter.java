package br.com.client.companyregistry.adapter.out.registry;

import br.com.client.companyregistry.application.port.out.CompanyRegistryPort;
import br.com.client.companyregistry.adapter.out.persistence.entity.CompanyEntity;
import br.com.client.companyregistry.adapter.out.persistence.entity.AddressEntity;
import br.com.client.companyregistry.adapter.out.persistence.repository.CompanyRepository;
import br.com.client.companyregistry.domain.model.Address;
import br.com.client.companyregistry.domain.model.BankAccount;
import br.com.client.companyregistry.domain.model.CompanyRegistryEntry;
import br.com.client.companyregistry.domain.model.Contact;
import br.com.client.companyregistry.domain.model.LogoMetadata;
import br.com.client.companyregistry.domain.model.PayrollSettings;
import br.com.client.companyregistry.domain.model.TaxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class InMemoryCompanyRegistryAdapter implements CompanyRegistryPort {

    private static final Logger log = LoggerFactory.getLogger(InMemoryCompanyRegistryAdapter.class);

    private final CompanyRepository companyRepository;

    public InMemoryCompanyRegistryAdapter(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<CompanyRegistryEntry> findByRegistration(String registrationNumber, String countryCode) {
        log.debug("Searching company in database for reg={} country={}", registrationNumber, countryCode);
        return companyRepository.findByRegistrationNumberAndCountryCode(registrationNumber, countryCode)
                .map(this::toDomain);
    }

    private CompanyRegistryEntry toDomain(CompanyEntity entity) {
        // Mapeamento dos endereços
        Address headOffice = entity.getAddresses().stream()
                .filter(a -> "HEADQUARTERS".equals(a.getTypeAddress()))
                .findFirst()
                .map(this::toAddressDomain)
                .orElse(null);

        List<Address> branches = entity.getAddresses().stream()
                .filter(a -> !"HEADQUARTERS".equals(a.getTypeAddress()))
                .map(this::toAddressDomain)
                .collect(Collectors.toList());

        List<Contact> contacts = entity.getContacts().stream()
                .map(c -> new Contact(c.getName(), c.getRole(), c.getEmail(), c.getPhone(), c.getDepartment()))
                .collect(Collectors.toList());

        return new CompanyRegistryEntry(
                entity.getExternalId(),
                entity.getRegistrationNumber(),
                entity.getCountryCode(),
                entity.getCorporateName(),
                entity.getTradeName(),
                entity.getStatus(),
                entity.getFoundationDate(),
                entity.getLegalType(),
                entity.getNature(),
                entity.getActivities(),
                headOffice,
                branches,
                contacts,
                new PayrollSettings(
                        entity.getPayrollSettings().currency,
                        entity.getPayrollSettings().frequency,
                        entity.getPayrollSettings().paymentMethod,
                        entity.getPayrollSettings().timeZone,
                        entity.getPayrollSettings().workWeekDef,
                        entity.getPayrollSettings().unionName,
                        entity.getPayrollSettings().vacationPolicy,
                        entity.getPayrollSettings().advancePolicy
                ),
                new BankAccount(
                        entity.getBankAccount().bankName,
                        entity.getBankAccount().agency,
                        entity.getBankAccount().account,
                        entity.getBankAccount().contactEmail,
                        entity.getBankAccount().routingNumber,
                        entity.getBankAccount().swiftCode,
                        entity.getBankAccount().accountType
                ),
                new TaxProfile(
                        entity.getTaxProfile().regime,
                        entity.getTaxProfile().taxId,
                        entity.getTaxProfile().stateTaxId,
                        entity.getTaxProfile().municipalTaxId,
                        Collections.emptyList(), // Simplificação: Listas do tax profile omitidas do SQL
                        Collections.emptyList()
                ),
                new LogoMetadata(
                        entity.getLogoMetadata().logoType,
                        entity.getLogoMetadata().url,
                        entity.getLogoMetadata().mimeType,
                        entity.getLogoMetadata().hash,
                        entity.getLogoMetadata().altText,
                        entity.getLogoMetadata().active
                ),
                entity.getMetadata(),
                entity.getTags(),
                entity.getDescription()
        );
    }

    private Address toAddressDomain(AddressEntity entity) {
        return new Address(
                entity.getStreet(),
                entity.getStreetNumber(),
                entity.getNeighborhood(),
                entity.getCity(),
                entity.getState(),
                entity.getZipCode(),
                entity.getCountry(),
                entity.getTypeAddress()
        );
    }
}
