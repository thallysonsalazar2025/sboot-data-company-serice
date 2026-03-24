package br.com.client.companyregistry.adapter.out.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", unique = true)
    private String externalId;

    @Column(name = "registration_number", unique = true) // CNPJ/EIN
    private String registrationNumber;

    @Column(name = "country_code")
    private String countryCode;

    private String corporateName;
    private String tradeName;
    private String status;
    private LocalDate foundationDate;
    private String legalType;
    private String nature;
    private String description;

    @ElementCollection
    @CollectionTable(name = "company_activities", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "activity")
    private List<String> activities = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private List<AddressEntity> addresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private List<ContactEntity> contacts = new ArrayList<>();

    // Embeddables para simplificar a estrutura de tabelas mantendo a organização
    @Embedded
    private PayrollSettingsEmbeddable payrollSettings;

    @Embedded
    private BankAccountEmbeddable bankAccount;

    @Embedded
    private TaxProfileEmbeddable taxProfile;

    @Embedded
    private LogoMetadataEmbeddable logoMetadata;

    @ElementCollection
    @CollectionTable(name = "company_metadata", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "meta_value")
    private List<String> metadata = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "company_tags", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "tag")
    private List<String> tags = new ArrayList<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }
    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
    public String getCorporateName() { return corporateName; }
    public void setCorporateName(String corporateName) { this.corporateName = corporateName; }
    public String getTradeName() { return tradeName; }
    public void setTradeName(String tradeName) { this.tradeName = tradeName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getFoundationDate() { return foundationDate; }
    public void setFoundationDate(LocalDate foundationDate) { this.foundationDate = foundationDate; }
    public String getLegalType() { return legalType; }
    public void setLegalType(String legalType) { this.legalType = legalType; }
    public String getNature() { return nature; }
    public void setNature(String nature) { this.nature = nature; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getActivities() { return activities; }
    public void setActivities(List<String> activities) { this.activities = activities; }
    public List<AddressEntity> getAddresses() { return addresses; }
    public void setAddresses(List<AddressEntity> addresses) { this.addresses = addresses; }
    public List<ContactEntity> getContacts() { return contacts; }
    public void setContacts(List<ContactEntity> contacts) { this.contacts = contacts; }
    public PayrollSettingsEmbeddable getPayrollSettings() { return payrollSettings; }
    public void setPayrollSettings(PayrollSettingsEmbeddable payrollSettings) { this.payrollSettings = payrollSettings; }
    public BankAccountEmbeddable getBankAccount() { return bankAccount; }
    public void setBankAccount(BankAccountEmbeddable bankAccount) { this.bankAccount = bankAccount; }
    public TaxProfileEmbeddable getTaxProfile() { return taxProfile; }
    public void setTaxProfile(TaxProfileEmbeddable taxProfile) { this.taxProfile = taxProfile; }
    public LogoMetadataEmbeddable getLogoMetadata() { return logoMetadata; }
    public void setLogoMetadata(LogoMetadataEmbeddable logoMetadata) { this.logoMetadata = logoMetadata; }
    public List<String> getMetadata() { return metadata; }
    public void setMetadata(List<String> metadata) { this.metadata = metadata; }
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
}