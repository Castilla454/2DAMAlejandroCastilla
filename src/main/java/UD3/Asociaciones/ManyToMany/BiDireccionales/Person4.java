package UD3.Asociaciones.ManyToMany.BiDireccionales;

import UD3.Asociaciones.ManyToMany.UniDireccionales.Address;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Person4 {
    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String registrationNumber;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Address2> addresses = new ArrayList<>();

    public Person4() {
    }

    public Person4(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Address2> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address2> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address2 address) {
       addresses.add(address);
       address.getOwners().add(this);
    }

    public void removeAddress(Address2 address) {
       addresses.remove(address);
       address.getOwners().remove(this);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person4 person4 = (Person4) o;
        return Objects.equals(id, person4.id) && Objects.equals(registrationNumber, person4.registrationNumber) && Objects.equals(addresses, person4.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationNumber, addresses);
    }
}

