# Company Registry Service

Serviço Spring Boot em arquitetura hexagonal para atender o orquestrador com dados cadastrais completos da empresa, enriquecidos para emissão de holerite de alto nível.

## Endpoint

```http
GET /api/v1/companies/registry?registrationNumber={value}&countryCode={value}
```

### Resposta

Retorna dados completos da empresa:
- identificação legal e comercial;
- endereços principal e complementares;
- contatos de RH, folha e jurídico;
- parâmetros de folha;
- dados bancários para crédito;
- perfil tributário;
- metadados do logo para documentos;
- identificadores do empregador e tags de compliance.

## Estratégia do logo

O logo foi modelado como parte da própria registry (`logo.source`, `logo.uri`, `logo.checksum` e `approvedForPayrollDocuments`).

Isso permite que o fluxo do orquestrador receba um payload único e consistente, sem depender de uma segunda chamada. Quando a empresa possuir gestão centralizada de marca, o campo `source` pode apontar para uma brand registry; quando o ativo pertencer à própria empresa, pode apontar para o CDN corporativo.
