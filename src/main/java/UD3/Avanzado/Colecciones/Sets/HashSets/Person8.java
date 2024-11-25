package UD3.Avanzado.Colecciones.Sets.HashSets;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PersonSet")
public class Person8 {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "PhonesSet", joinColumns = @JoinColumn(name = "person_id"))
    private Set<String> phones = new HashSet<String>();

    public Person8() {
    }

    public Person8(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }
}
