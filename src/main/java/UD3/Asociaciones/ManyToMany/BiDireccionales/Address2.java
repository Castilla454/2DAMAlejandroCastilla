package UD3.Asociaciones.ManyToMany.BiDireccionales;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Address2 {
    @Id
    @GeneratedValue
    private long id;

    private String street;

    @Column(name = "number")
    private String number;

    private String postalCode;

    @ManyToMany(mappedBy = "addresses")
    private List<Person4> owners = new ArrayList<>();

    public Address2() {
    }

    public Address2(String street, String number, String postalCode) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Person4> getOwners() {
        return owners;
    }

    public void setOwners(List<Person4> owners) {
        this.owners = owners;
    }
}
