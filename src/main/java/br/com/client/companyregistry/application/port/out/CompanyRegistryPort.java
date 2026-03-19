package br.com.client.companyregistry.application.port.out;

import br.com.client.companyregistry.domain.model.CompanyRegistryEntry;

import java.util.Optional;

public interface CompanyRegistryPort {

    Optional<CompanyRegistryEntry> findByRegistration(String registrationNumber, String countryCode);
}
