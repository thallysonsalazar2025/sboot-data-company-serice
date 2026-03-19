package br.com.client.companyregistry.adapter.in.web.dto;

import java.time.LocalDate;
import java.util.List;

public record CompanyRegistryResponse(
        String companyId,
        String registrationNumber,
        String countryCode,
        String legalName,
        String tradeName,
        String status,
        LocalDate incorporationDate,
        String companyType,
        String primaryEconomicActivity,
        List<String> secondaryEconomicActivities,
        AddressResponse headquarters,
        List<AddressResponse> additionalAddresses,
        List<ContactResponse> contacts,
        PayrollSettingsResponse payrollSettings,
        BankAccountResponse payrollBankAccount,
        TaxProfileResponse taxProfile,
        LogoMetadataResponse logo,
        List<String> employerIdentifiers,
        List<String> complianceTags,
        String notes
) {
    public record AddressResponse(
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

    public record ContactResponse(
            String name,
            String role,
            String email,
            String phone,
            String type
    ) {
    }

    public record PayrollSettingsResponse(
            String defaultCurrency,
            String paymentFrequency,
            String paymentMethod,
            String timezone,
            String workingHoursRegime,
            String collectiveAgreement,
            String vacationPolicy,
            String thirteenthSalaryRule
    ) {
    }

    public record BankAccountResponse(
            String bankName,
            String branch,
            String accountNumber,
            String pixKey,
            String iban,
            String swift,
            String accountType
    ) {
    }

    public record TaxProfileResponse(
            String taxRegime,
            String federalRegistration,
            String stateRegistration,
            String municipalRegistration,
            List<String> taxIncentives,
            List<String> laborBenefitPrograms
    ) {
    }

    public record LogoMetadataResponse(
            String source,
            String uri,
            String mimeType,
            String checksum,
            String fallbackText,
            boolean approvedForPayrollDocuments
    ) {
    }
}
