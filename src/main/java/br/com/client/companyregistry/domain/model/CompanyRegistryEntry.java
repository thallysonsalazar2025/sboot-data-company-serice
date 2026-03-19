package br.com.client.companyregistry.domain.model;

import java.time.LocalDate;
import java.util.List;

public record CompanyRegistryEntry(
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
        Address headquarters,
        List<Address> additionalAddresses,
        List<Contact> contacts,
        PayrollSettings payrollSettings,
        BankAccount payrollBankAccount,
        TaxProfile taxProfile,
        LogoMetadata logo,
        List<String> employerIdentifiers,
        List<String> complianceTags,
        String notes
) {
}
