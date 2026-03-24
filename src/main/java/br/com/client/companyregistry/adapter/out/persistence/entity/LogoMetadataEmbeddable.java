package br.com.client.companyregistry.adapter.out.persistence.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class LogoMetadataEmbeddable {
    public String logoType;
    public String url;
    public String mimeType;
    public String hash;
    public String altText;
    public Boolean active;
}
