package br.com.client.companyregistry.application.service;

import br.com.client.companyregistry.application.port.in.GetCompanyRegistryUseCase;
import br.com.client.companyregistry.application.port.out.CompanyRegistryPort;
import br.com.client.companyregistry.domain.exception.CompanyNotFoundException;
import br.com.client.companyregistry.domain.model.CompanyRegistryEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetCompanyRegistryService implements GetCompanyRegistryUseCase {

    private static final Logger log = LoggerFactory.getLogger(GetCompanyRegistryService.class);

    private final CompanyRegistryPort companyRegistryPort;

    public GetCompanyRegistryService(CompanyRegistryPort companyRegistryPort) {
        this.companyRegistryPort = companyRegistryPort;
    }

    @Override
    public CompanyRegistryEntry execute(String registrationNumber, String countryCode) {
        log.info("Looking up company registry data for registrationNumber={} and countryCode={}", registrationNumber, countryCode);

        return companyRegistryPort.findByRegistration(registrationNumber, countryCode)
                .map(company -> {
                    log.info("Company registry data found for companyId={} registrationNumber={}", company.companyId(), registrationNumber);
                    return company;
                })
                .orElseThrow(() -> {
                    log.warn("Company registry data not found for registrationNumber={} and countryCode={}", registrationNumber, countryCode);
                    return new CompanyNotFoundException(registrationNumber, countryCode);
                });
    }
}
