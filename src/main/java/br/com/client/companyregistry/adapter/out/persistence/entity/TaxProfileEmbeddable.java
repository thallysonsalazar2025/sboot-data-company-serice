package br.com.client.companyregistry.adapter.out.persistence.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class TaxProfileEmbeddable {
    public String regime;
    public String taxId;
    public String stateTaxId;
    public String municipalTaxId;
    // Para simplificar no SQL, não mapearemos as listas internas do TaxProfile aqui
    // ou usaremos um campo texto separado se necessário.
}
