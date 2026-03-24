package br.com.client.companyregistry.adapter.out.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String streetNumber;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String typeAddress; // HEADQUARTERS, BRANCH, etc.

    // Getters/Setters omitidos para brevidade, mas necessários
    public String getStreet() { return street; } public void setStreet(String s) { street = s; }
    public String getStreetNumber() { return streetNumber; } public void setStreetNumber(String s) { streetNumber = s; }
    public String getNeighborhood() { return neighborhood; } public void setNeighborhood(String s) { neighborhood = s; }
    public String getCity() { return city; } public void setCity(String s) { city = s; }
    public String getState() { return state; } public void setState(String s) { state = s; }
    public String getZipCode() { return zipCode; } public void setZipCode(String s) { zipCode = s; }
    public String getCountry() { return country; } public void setCountry(String s) { country = s; }
    public String getTypeAddress() { return typeAddress; } public void setTypeAddress(String s) { typeAddress = s; }
}