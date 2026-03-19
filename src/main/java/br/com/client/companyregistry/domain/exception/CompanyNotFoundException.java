package br.com.client.companyregistry.domain.exception;

public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException(String registrationNumber, String countryCode) {
        super("Company not found for registrationNumber=%s and countryCode=%s".formatted(registrationNumber, countryCode));
    }
}
