package br.com.client.companyregistry.domain.model;

public record Contact(
        String name,
        String role,
        String email,
        String phone,
        String type
) {
}
