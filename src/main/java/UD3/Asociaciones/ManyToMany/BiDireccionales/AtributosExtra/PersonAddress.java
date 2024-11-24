package UD3.Asociaciones.ManyToMany.BiDireccionales.AtributosExtra;

import UD3.Asociaciones.ManyToMany.BiDireccionales.Address2;
import UD3.Asociaciones.ManyToMany.BiDireccionales.Person4;
import jakarta.persistence.*;

@Entity
@IdClass(PersonAddressId.class)
public class PersonAddress {

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id",
            insertable = false, updatable = false)
    private Person5 person;

    @Id
    @ManyToOne
    @JoinColumn(name = "address_id",
            insertable = false, updatable = false)
    private Address3 address;

    private String nameOfAddress;

    public PersonAddress() {
    }

    public PersonAddress(Person5 person, Address3 address) {
        this.person = person;
        this.address = address;
    }

    public PersonAddress(Person5 person, Address3 address, String nameOfAddress) {
        this.person = person;
        this.address = address;
        this.nameOfAddress = nameOfAddress;
    }

    public Person5 getPerson() {
        return person;
    }

    public void setPerson(Person5 person) {
        this.person = person;
    }

    public Address3 getAddress() {
        return address;
    }

    public void setAddress(Address3 address) {
        this.address = address;
    }

    public String getNameOfAddress() {
        return nameOfAddress;
    }

    public void setNameOfAddress(String nameOfAddress) {
        this.nameOfAddress = nameOfAddress;
    }
}

