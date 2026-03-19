package br.com.client.companyregistry.domain.model;

import java.util.List;

public record TaxProfile(
        String taxRegime,
        String federalRegistration,
        String stateRegistration,
        String municipalRegistration,
        List<String> taxIncentives,
        List<String> laborBenefitPrograms
) {
}
