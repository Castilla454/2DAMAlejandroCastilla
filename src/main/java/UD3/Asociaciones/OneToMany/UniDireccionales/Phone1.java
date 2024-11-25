package UD3.Asociaciones.OneToMany.UniDireccionales;

import jakarta.persistence.*;

@Entity
public class Phone1 {
    @Id
    @GeneratedValue
    private long id;


    private String number;


    public Phone1() {
    }

    public Phone1(String number) {
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


}