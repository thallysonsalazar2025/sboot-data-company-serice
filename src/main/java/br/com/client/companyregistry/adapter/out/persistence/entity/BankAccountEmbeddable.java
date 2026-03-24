package br.com.client.companyregistry.adapter.out.persistence.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class BankAccountEmbeddable {
    public String bankName;
    public String agency;
    public String account;
    public String contactEmail;
    public String routingNumber;
    public String swiftCode;
    public String accountType;
}
