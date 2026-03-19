package br.com.client.companyregistry.domain.model;

public record PayrollSettings(
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
