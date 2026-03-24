package br.com.client.companyregistry.application.service;

import br.com.client.companyregistry.application.port.in.FindCompanyByRegistrationUseCase;
import br.com.client.companyregistry.application.port.out.CompanyRegistryPort;
import br.com.client.companyregistry.domain.model.CompanyRegistryEntry;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindCompanyByRegistrationService implements FindCompanyByRegistrationUseCase {

    private final CompanyRegistryPort companyRegistryPort;

    public FindCompanyByRegistrationService(CompanyRegistryPort companyRegistryPort) {
        this.companyRegistryPort = companyRegistryPort;
    }

    @Override
    public Optional<CompanyRegistryEntry> find(String registrationNumber, String countryCode) {
        return companyRegistryPort.findByRegistration(registrationNumber, countryCode);
    }
}