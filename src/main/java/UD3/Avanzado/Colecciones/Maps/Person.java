package UD3.Avanzado.Colecciones.Maps;

import jakarta.persistence.*;
import org.hibernate.annotations.SortNatural;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity(name = "PersonMap")
@Table(name = "PersonMap")
public class Person {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "PhonesMap", joinColumns = @JoinColumn(name = "person_id"))
    private Map<String, String> phones = new HashMap<String, String>();

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


    public Map<String, String> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }


}