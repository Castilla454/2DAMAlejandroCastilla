package UD3.Avanzado.Colecciones.Lists;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "PersonList")
public class Person7 {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "PhonesList", joinColumns = @JoinColumn(name = "person_id"))
    @OrderColumn(name = "order_id")
    private List<String> phones = new ArrayList<String>();

    public Person7() {
    }

    public Person7(String name) {
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


    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
