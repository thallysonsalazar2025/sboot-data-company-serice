package br.com.client.companyregistry.domain.model;

public record Address(
        String street,
        String number,
        String district,
        String city,
        String state,
        String postalCode,
        String countryCode,
        String addressType
) {
}
