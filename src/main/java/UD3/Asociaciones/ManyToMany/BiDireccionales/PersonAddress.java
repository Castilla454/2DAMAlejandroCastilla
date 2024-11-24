package UD3.Asociaciones.ManyToMany.BiDireccionales;

import jakarta.persistence.*;

@Entity
@IdClass(PersonAddressId.class)
public class PersonAddress {
    @Id
    @ManyToOne
    @JoinColumn(name = "person_id",insertable = false, updatable = false)
    private Person4 person;

    @Id
    @ManyToOne
    @JoinColumn(name = "address_id",insertable = false, updatable = false)
    private Address2 address;
}
