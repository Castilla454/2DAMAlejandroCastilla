package UD3.Asociaciones.OneToMany.BiDireccionales;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.Objects;

@Entity
public class Phone2 {
    @Id
    @GeneratedValue
    private long id;


@NaturalId
@Column(unique = true)
    private String number;

@ManyToOne
private Person2 person2;

    public Phone2() {
    }

    public Phone2(String number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person2 getPerson2() {
        return person2;
    }

    public void setPerson2(Person2 person2) {
        this.person2 = person2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone2 phone2 = (Phone2) o;
        return id == phone2.id && Objects.equals(number, phone2.number) && Objects.equals(person2, phone2.person2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, person2);
    }
}