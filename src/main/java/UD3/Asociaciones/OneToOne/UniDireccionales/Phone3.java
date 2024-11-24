package UD3.Asociaciones.OneToOne.UniDireccionales;

import jakarta.persistence.*;

@Entity
public class Phone3 {
    @Id
    @GeneratedValue
    private long id;


    private String number;


    @OneToOne
    @JoinColumn(name = "details_id")
    private PhoneDetails phoneDetails;

    public Phone3() {
    }

    public Phone3(String number) {
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

    public PhoneDetails getPhoneDetails() {
        return phoneDetails;
    }

    public void setPhoneDetails(PhoneDetails phoneDetails) {
        this.phoneDetails = phoneDetails;
    }

}
