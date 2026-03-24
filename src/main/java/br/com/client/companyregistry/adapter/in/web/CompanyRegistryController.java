package br.com.client.companyregistry.adapter.in.web;

import br.com.client.companyregistry.adapter.in.web.dto.CompanyRegistryResponse;
import br.com.client.companyregistry.adapter.in.web.mapper.CompanyRegistryResponseMapper;
import br.com.client.companyregistry.application.port.in.GetCompanyRegistryUseCase;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.api.company-registry-path}")
@Validated
public class CompanyRegistryController {

    private static final Logger log = LoggerFactory.getLogger(CompanyRegistryController.class);

    private final GetCompanyRegistryUseCase getCompanyRegistryUseCase;
    private final CompanyRegistryResponseMapper mapper;

    public CompanyRegistryController(GetCompanyRegistryUseCase getCompanyRegistryUseCase,
                                     CompanyRegistryResponseMapper mapper) {
        this.getCompanyRegistryUseCase = getCompanyRegistryUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public CompanyRegistryResponse findCompany(
            @RequestParam @NotBlank String registrationNumber,
            @RequestParam(required = false) String countryCode) {

        String normalizedCountryCode = mapper.normalizeCountryCode(countryCode);
        log.info("Received registry lookup request for registrationNumber={} and countryCode={}", registrationNumber, normalizedCountryCode);
        return mapper.toResponse(getCompanyRegistryUseCase.execute(registrationNumber, normalizedCountryCode));
    }
}
