package UD3.Asociaciones.OneToMany.BiDireccionales;
import UD3.Asociaciones.OneToMany.UniDireccionales.Phone1;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person2 {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "person2",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone2> phones = new ArrayList<>();

    private String name;

    public Person2() {
    }

    public Person2(String name) {
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


    public void addPhone(Phone2 phone) {
        phones.add(phone);
        phone.setPerson2(this);
    }

    public void removePhone(Phone2 phone) {
        phones.remove(phone);
        phone.setPerson2(null);
    }

    public List<Phone2> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone2> phones) {
        this.phones = phones;
    }
}
