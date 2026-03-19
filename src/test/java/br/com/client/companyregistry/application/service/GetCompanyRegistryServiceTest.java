package br.com.client.companyregistry.application.service;

import br.com.client.companyregistry.application.port.out.CompanyRegistryPort;
import br.com.client.companyregistry.domain.exception.CompanyNotFoundException;
import br.com.client.companyregistry.domain.model.Address;
import br.com.client.companyregistry.domain.model.BankAccount;
import br.com.client.companyregistry.domain.model.CompanyRegistryEntry;
import br.com.client.companyregistry.domain.model.Contact;
import br.com.client.companyregistry.domain.model.LogoMetadata;
import br.com.client.companyregistry.domain.model.PayrollSettings;
import br.com.client.companyregistry.domain.model.TaxProfile;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetCompanyRegistryServiceTest {

    private final CompanyRegistryPort companyRegistryPort = mock(CompanyRegistryPort.class);
    private final GetCompanyRegistryService service = new GetCompanyRegistryService(companyRegistryPort);

    @Test
    void shouldReturnCompanyRegistryEntryWhenFound() {
        CompanyRegistryEntry entry = sampleEntry();
        when(companyRegistryPort.findByRegistration("12345678000195", "BR")).thenReturn(Optional.of(entry));

        CompanyRegistryEntry result = service.execute("12345678000195", "BR");

        assertThat(result).isEqualTo(entry);
    }

    @Test
    void shouldThrowExceptionWhenCompanyDoesNotExist() {
        when(companyRegistryPort.findByRegistration("000", "BR")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.execute("000", "BR"))
                .isInstanceOf(CompanyNotFoundException.class)
                .hasMessageContaining("registrationNumber=000");
    }

    private CompanyRegistryEntry sampleEntry() {
        return new CompanyRegistryEntry(
                "COMPANY-BR-001",
                "12345678000195",
                "BR",
                "ACME Tecnologia e Serviços Ltda.",
                "ACME Tech",
                "ACTIVE",
                LocalDate.of(2014, 5, 12),
                "PRIVATE_LIMITED",
                "Desenvolvimento de software sob encomenda",
                List.of("Consultoria em tecnologia da informação"),
                new Address("Avenida Paulista", "1500", "Bela Vista", "São Paulo", "SP", "01310-200", "BR", "HEADQUARTERS"),
                List.of(),
                List.of(new Contact("Mariana Costa", "HR Director", "mariana.costa@acme.example", "+55-11-4000-1000", "HR")),
                new PayrollSettings("BRL", "MONTHLY", "BANK_TRANSFER", "America/Sao_Paulo", "44H_WEEK", "Sindpd-SP", "30_CALENDAR_DAYS", "ADVANCE_OPTIONAL"),
                new BankAccount("Banco do Brasil", "1234-5", "98765-4", "financeiro@acme.example", null, "BRASBRRJSPO", "CHECKING"),
                new TaxProfile("LUCRO_REAL", "12.345.678/0001-95", "110042490114", "99887766", List.of("Lei do Bem"), List.of("PAT")),
                new LogoMetadata("COMPANY_ASSET_CDN", "https://assets.client.example/logos/acme-tech.svg", "image/svg+xml", "sha256:9d3ca9db8f68f6", "ACME Tech", true),
                List.of("EMPLOYER_CODE:BR-SP-7788"),
                List.of("LGPD_REVIEWED"),
                "Empresa apta para emissão de holerites premium."
        );
    }
}
