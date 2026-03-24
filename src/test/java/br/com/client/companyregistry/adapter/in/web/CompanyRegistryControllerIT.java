package br.com.client.companyregistry.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CompanyRegistryControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnDetailedCompanyDataForPayrollFlow() throws Exception {
        mockMvc.perform(get("/api/v1/companies/registry")
                        .param("registrationNumber", "12345678000195")
                        .param("countryCode", "BR"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyId").value("COMPANY-BR-001"))
                .andExpect(jsonPath("$.legalName").value("ACME Tecnologia e Serviços Ltda."))
                .andExpect(jsonPath("$.payrollSettings.defaultCurrency").value("BRL"))
                .andExpect(jsonPath("$.logo.source").value("COMPANY_ASSET_CDN"))
                .andExpect(jsonPath("$.employerIdentifiers[0]").value("EMPLOYER_CODE:BR-SP-7788"));
    }

    @Test
    void shouldReturnNotFoundWhenRegistryEntryDoesNotExist() throws Exception {
        mockMvc.perform(get("/api/v1/companies/registry")
                        .param("registrationNumber", "000")
                        .param("countryCode", "BR"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Company Not Found"));
    }

    @Test
    void shouldReturnBadRequestWhenRequiredParameterIsBlank() throws Exception {
        mockMvc.perform(get("/api/v1/companies/registry")
                        .param("registrationNumber", "")
                        .param("countryCode", "BR"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Validation Error"));
    }

    @Test
    void shouldFallbackCountryCodeToBrazilWhenValueIsBlank() throws Exception {
        mockMvc.perform(get("/api/v1/companies/registry")
                        .param("registrationNumber", "12345678000195")
                        .param("countryCode", ""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyId").value("COMPANY-BR-001"))
                .andExpect(jsonPath("$.countryCode").value("BR"));
    }
}
