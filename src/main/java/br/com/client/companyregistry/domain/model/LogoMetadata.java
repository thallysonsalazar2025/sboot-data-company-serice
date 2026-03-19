package br.com.client.companyregistry.domain.model;

public record LogoMetadata(
        String source,
        String uri,
        String mimeType,
        String checksum,
        String fallbackText,
        boolean approvedForPayrollDocuments
) {
}
