package UD3.Asociaciones.ManyToOne;

import jakarta.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private long id;


    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "PERSON_ID_FK"))

    private Person person;

    public Phone() {
    }

    public Phone(String number) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
