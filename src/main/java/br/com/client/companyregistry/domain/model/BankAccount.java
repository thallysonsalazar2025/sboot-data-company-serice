package br.com.client.companyregistry.domain.model;

public record BankAccount(
        String bankName,
        String branch,
        String accountNumber,
        String pixKey,
        String iban,
        String swift,
        String accountType
) {
}
