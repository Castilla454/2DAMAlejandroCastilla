package UD3.Asociaciones.OneToMany.UniDireccionales;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person1 {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Phone1> phones = new ArrayList<>();

    private String name;
    public Person1() {
    }
    public Person1(String name) {
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

    public List<Phone1> getPhones() {
        return phones;
    }
    public void setPhones(List<Phone1> phones) {
        this.phones = phones;
    }








}
