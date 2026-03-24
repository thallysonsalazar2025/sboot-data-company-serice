package br.com.client.companyregistry.application.port.in;

import br.com.client.companyregistry.domain.model.CompanyRegistryEntry;

import java.util.Optional;

public interface FindCompanyByRegistrationUseCase {
    Optional<CompanyRegistryEntry> find(String registrationNumber, String countryCode);
}