package br.com.client.companyregistry.adapter.out.persistence.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class PayrollSettingsEmbeddable {
    public String currency;
    public String frequency;
    public String paymentMethod;
    public String timeZone;
    public String workWeekDef;
    public String unionName;
    public String vacationPolicy;
    public String advancePolicy;
}
