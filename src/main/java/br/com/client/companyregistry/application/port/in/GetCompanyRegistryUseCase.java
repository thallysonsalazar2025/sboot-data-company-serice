package br.com.client.companyregistry.application.port.in;

import br.com.client.companyregistry.domain.model.CompanyRegistryEntry;

public interface GetCompanyRegistryUseCase {

    CompanyRegistryEntry execute(String registrationNumber, String countryCode);
}
