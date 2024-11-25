package UD3.Asociaciones.ManyToMany.BiDireccionales.AtributosExtra;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person5 {
    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String registrationNumber;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonAddress> addresses = new ArrayList<>();

    public Person5() {
    }

    public Person5(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public List<PersonAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<PersonAddress> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address3 address, String name) {
        PersonAddress personAddress = new PersonAddress(this, address, name);
        addresses.add(personAddress);
        address.getOwners().add(personAddress);
    }

    public void removeAddress(Address3 address) {
        PersonAddress personAddress = new PersonAddress(this, address);
        address.getOwners().remove(personAddress);
        addresses.remove(personAddress);
    }
}
