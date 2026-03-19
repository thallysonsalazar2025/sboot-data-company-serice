package br.com.client.companyregistry.adapter.out.registry;

import br.com.client.companyregistry.application.port.out.CompanyRegistryPort;
import br.com.client.companyregistry.domain.model.Address;
import br.com.client.companyregistry.domain.model.BankAccount;
import br.com.client.companyregistry.domain.model.CompanyRegistryEntry;
import br.com.client.companyregistry.domain.model.Contact;
import br.com.client.companyregistry.domain.model.LogoMetadata;
import br.com.client.companyregistry.domain.model.PayrollSettings;
import br.com.client.companyregistry.domain.model.TaxProfile;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryCompanyRegistryAdapter implements CompanyRegistryPort {

    private static final Logger log = LoggerFactory.getLogger(InMemoryCompanyRegistryAdapter.class);

    private final Map<String, CompanyRegistryEntry> registry = new ConcurrentHashMap<>();

    @PostConstruct
    void init() {
        CompanyRegistryEntry acmeBrazil = new CompanyRegistryEntry(
                "COMPANY-BR-001",
                "12345678000195",
                "BR",
                "ACME Tecnologia e Serviços Ltda.",
                "ACME Tech",
                "ACTIVE",
                LocalDate.of(2014, 5, 12),
                "PRIVATE_LIMITED",
                "Desenvolvimento de software sob encomenda",
                List.of("Consultoria em tecnologia da informação", "Processamento de dados e folha de pagamento"),
                new Address("Avenida Paulista", "1500", "Bela Vista", "São Paulo", "SP", "01310-200", "BR", "HEADQUARTERS"),
                List.of(
                        new Address("Rua dos Andradas", "450", "Centro Histórico", "Porto Alegre", "RS", "90020-006", "BR", "PAYROLL_HUB"),
                        new Address("Rua da Bahia", "1200", "Funcionários", "Belo Horizonte", "MG", "30160-011", "BR", "FISCAL_BRANCH")
                ),
                List.of(
                        new Contact("Mariana Costa", "HR Director", "mariana.costa@acme.example", "+55-11-4000-1000", "HR"),
                        new Contact("Renato Lima", "Payroll Specialist", "payroll@acme.example", "+55-11-4000-2000", "PAYROLL"),
                        new Contact("Camila Souza", "Legal Representative", "juridico@acme.example", "+55-11-4000-3000", "LEGAL")
                ),
                new PayrollSettings("BRL", "MONTHLY", "BANK_TRANSFER", "America/Sao_Paulo", "44H_WEEK", "Sindpd-SP", "30_CALENDAR_DAYS", "ADVANCE_OPTIONAL"),
                new BankAccount("Banco do Brasil", "1234-5", "98765-4", "financeiro@acme.example", null, "BRASBRRJSPO", "CHECKING"),
                new TaxProfile("LUCRO_REAL", "12.345.678/0001-95", "110042490114", "99887766", List.of("Lei do Bem"), List.of("PAT", "Empresa Cidadã")),
                new LogoMetadata("COMPANY_ASSET_CDN", "https://assets.client.example/logos/acme-tech.svg", "image/svg+xml", "sha256:9d3ca9db8f68f6", "ACME Tech", true),
                List.of("EMPLOYER_CODE:BR-SP-7788", "ESOCIAL:100200300", "FGTS:55443322"),
                List.of("LGPD_REVIEWED", "PAYROLL_APPROVED", "KYC_VERIFIED"),
                "Empresa apta para emissão de holerites premium com detalhamento fiscal e bancário."
        );

        CompanyRegistryEntry acmeUs = new CompanyRegistryEntry(
                "COMPANY-US-001",
                "98-7654321",
                "US",
                "ACME Mobility Inc.",
                "ACME Mobility",
                "ACTIVE",
                LocalDate.of(2018, 2, 20),
                "CORPORATION",
                "Mobility platform operations",
                List.of("Payroll administration services", "Data analytics"),
                new Address("5th Avenue", "350", "Midtown", "New York", "NY", "10018", "US", "HEADQUARTERS"),
                List.of(new Address("Congress Ave", "800", "Downtown", "Austin", "TX", "78701", "US", "PAYROLL_HUB")),
                List.of(
                        new Contact("Jennifer Cole", "People Operations Lead", "people@acmemobility.example", "+1-212-555-1000", "HR"),
                        new Contact("Victor Hall", "Payroll Manager", "payroll-us@acmemobility.example", "+1-212-555-2000", "PAYROLL")
                ),
                new PayrollSettings("USD", "BIWEEKLY", "ACH", "America/New_York", "40H_WEEK", "N/A", "PTO_POLICY_A", "NOT_APPLICABLE"),
                new BankAccount("Bank of America", "0001", "9988776655", null, "US00ACME9988776655", "BOFAUS3N", "CHECKING"),
                new TaxProfile("C_CORP", "98-7654321", null, null, List.of("R&D Credit"), List.of("401K_MATCH", "COMMUTER_BENEFIT")),
                new LogoMetadata("BRAND_REGISTRY", "https://assets.client.example/logos/acme-mobility.png", "image/png", "sha256:2198ba77ee1201", "ACME Mobility", true),
                List.of("EIN:98-7654321", "STATE_PAYROLL:NY-778899"),
                List.of("SOC2_REVIEWED", "PAYROLL_APPROVED"),
                "Brand logo mantido na registry de marca para unificar documentos multi-country."
        );

        registry.put(key(acmeBrazil.registrationNumber(), acmeBrazil.countryCode()), acmeBrazil);
        registry.put(key(acmeUs.registrationNumber(), acmeUs.countryCode()), acmeUs);

        log.info("Company registry initialized with {} entries", registry.size());
    }

    @Override
    public Optional<CompanyRegistryEntry> findByRegistration(String registrationNumber, String countryCode) {
        String key = key(registrationNumber, countryCode);
        log.debug("Searching company registry entry with key={}", key);
        return Optional.ofNullable(registry.get(key));
    }

    private String key(String registrationNumber, String countryCode) {
        return registrationNumber.trim() + "::" + countryCode.trim().toUpperCase();
    }
}
