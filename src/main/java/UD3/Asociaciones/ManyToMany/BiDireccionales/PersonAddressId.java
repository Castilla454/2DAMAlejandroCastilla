package UD3.Asociaciones.ManyToMany.BiDireccionales;

import java.io.Serializable;
import java.util.Objects;

public class PersonAddressId implements Serializable {
    private Long person;
    private Long address;

    public PersonAddressId() {
    }


    public PersonAddressId(Long person, Long address) {
        this.person = person;
        this.address = address;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAddressId that = (PersonAddressId) o;
        return Objects.equals(person, that.person) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, address);
    }
}
