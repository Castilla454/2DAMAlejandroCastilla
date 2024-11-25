package UD3.Asociaciones.ManyToMany.BiDireccionales.AtributosExtra;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Address3 {
    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String number;
    private String postalCode;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonAddress> owners = new ArrayList<>();

    public Address3() {
    }

    public Address3(String street, String number, String postalCode) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<PersonAddress> getOwners() {
        return owners;
    }

    public void setOwners(List<PersonAddress> owners) {
        this.owners = owners;
    }
}
