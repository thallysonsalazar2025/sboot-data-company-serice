package br.com.client.companyregistry.adapter.in.web.mapper;

import br.com.client.companyregistry.adapter.in.web.dto.CompanyRegistryResponse;
import br.com.client.companyregistry.domain.model.Address;
import br.com.client.companyregistry.domain.model.BankAccount;
import br.com.client.companyregistry.domain.model.CompanyRegistryEntry;
import br.com.client.companyregistry.domain.model.Contact;
import br.com.client.companyregistry.domain.model.LogoMetadata;
import br.com.client.companyregistry.domain.model.PayrollSettings;
import br.com.client.companyregistry.domain.model.TaxProfile;
import org.springframework.stereotype.Component;

@Component
public class CompanyRegistryResponseMapper {

    public CompanyRegistryResponse toResponse(CompanyRegistryEntry entry) {
        return new CompanyRegistryResponse(
                entry.companyId(),
                entry.registrationNumber(),
                entry.countryCode(),
                entry.legalName(),
                entry.tradeName(),
                entry.status(),
                entry.incorporationDate(),
                entry.companyType(),
                entry.primaryEconomicActivity(),
                entry.secondaryEconomicActivities(),
                toAddress(entry.headquarters()),
                entry.additionalAddresses().stream().map(this::toAddress).toList(),
                entry.contacts().stream().map(this::toContact).toList(),
                toPayrollSettings(entry.payrollSettings()),
                toBankAccount(entry.payrollBankAccount()),
                toTaxProfile(entry.taxProfile()),
                toLogo(entry.logo()),
                entry.employerIdentifiers(),
                entry.complianceTags(),
                entry.notes()
        );
    }

    private CompanyRegistryResponse.AddressResponse toAddress(Address address) {
        return new CompanyRegistryResponse.AddressResponse(
                address.street(),
                address.number(),
                address.district(),
                address.city(),
                address.state(),
                address.postalCode(),
                address.countryCode(),
                address.addressType()
        );
    }

    private CompanyRegistryResponse.ContactResponse toContact(Contact contact) {
        return new CompanyRegistryResponse.ContactResponse(
                contact.name(),
                contact.role(),
                contact.email(),
                contact.phone(),
                contact.type()
        );
    }

    private CompanyRegistryResponse.PayrollSettingsResponse toPayrollSettings(PayrollSettings payrollSettings) {
        return new CompanyRegistryResponse.PayrollSettingsResponse(
                payrollSettings.defaultCurrency(),
                payrollSettings.paymentFrequency(),
                payrollSettings.paymentMethod(),
                payrollSettings.timezone(),
                payrollSettings.workingHoursRegime(),
                payrollSettings.collectiveAgreement(),
                payrollSettings.vacationPolicy(),
                payrollSettings.thirteenthSalaryRule()
        );
    }

    private CompanyRegistryResponse.BankAccountResponse toBankAccount(BankAccount bankAccount) {
        return new CompanyRegistryResponse.BankAccountResponse(
                bankAccount.bankName(),
                bankAccount.branch(),
                bankAccount.accountNumber(),
                bankAccount.pixKey(),
                bankAccount.iban(),
                bankAccount.swift(),
                bankAccount.accountType()
        );
    }

    private CompanyRegistryResponse.TaxProfileResponse toTaxProfile(TaxProfile taxProfile) {
        return new CompanyRegistryResponse.TaxProfileResponse(
                taxProfile.taxRegime(),
                taxProfile.federalRegistration(),
                taxProfile.stateRegistration(),
                taxProfile.municipalRegistration(),
                taxProfile.taxIncentives(),
                taxProfile.laborBenefitPrograms()
        );
    }

    private CompanyRegistryResponse.LogoMetadataResponse toLogo(LogoMetadata logoMetadata) {
        return new CompanyRegistryResponse.LogoMetadataResponse(
                logoMetadata.source(),
                logoMetadata.uri(),
                logoMetadata.mimeType(),
                logoMetadata.checksum(),
                logoMetadata.fallbackText(),
                logoMetadata.approvedForPayrollDocuments()
        );
    }
}
