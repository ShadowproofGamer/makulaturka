package com.example.makulaturka.address;

import jakarta.persistence.*;


@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String buildingNumber;
    private String flatNumber;
    private String postalCode;
    private String city;

    /**
     * konstruktor adresu
     * @param id
     * @param street
     * @param buildingNumber
     * @param flatNumber
     * @param postalCode
     * @param city
     */
    public Address(Long id, String street, String buildingNumber, String flatNumber, String postalCode, String city) {
        this.id = id;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    /**
     * konstruktor nowego adresu
     * @param street
     * @param buildingNumber
     * @param flatNumber
     * @param postalCode
     * @param city
     */
    public Address(String street, String buildingNumber, String flatNumber, String postalCode, String city) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street='" + street + '\'' + ", buildingNumber='" + buildingNumber + '\'' + ", flatNumber='" + flatNumber + '\'' + ", postalCode='" + postalCode + '\'' + ", city='" + city + '\'' + '}';
    }

//    public String humanReadableStringPL() {
//        return "Adres: \n" + "Ulica = " + street + "\n" + "Budynek = " + buildingNumber + "\n" + "Mieszkanie = nr " + flatNumber + "\n" + "Kod pocztowy = " + postalCode + "\n" + "Miasto = " + city;
//    }
}
