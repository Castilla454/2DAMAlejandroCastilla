package UD3.Avanzado.Colecciones.Sets.SortedSets;

import jakarta.persistence.*;
import org.hibernate.annotations.SortNatural;

import java.util.SortedSet;
import java.util.TreeSet;

@Entity(name = "PersonSortedSet")
@Table(name = "PersonSortedSet")
public class Person {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "PhonesSortedSet", joinColumns = @JoinColumn(name = "person_id"))
    @SortNatural
    private SortedSet<String> phones = new TreeSet<String>();

    public Person() {
    }

    public Person(String name) {
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


    public SortedSet<String> getPhones() {
        return phones;
    }

    public void setPhones(SortedSet<String> phones) {
        this.phones = phones;
    }

}
