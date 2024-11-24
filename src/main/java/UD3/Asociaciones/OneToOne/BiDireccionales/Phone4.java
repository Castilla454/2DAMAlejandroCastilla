package UD3.Asociaciones.OneToOne.BiDireccionales;

import UD3.Asociaciones.OneToOne.UniDireccionales.PhoneDetails;
import jakarta.persistence.*;

@Entity
public class Phone4 {
    @Id
    @GeneratedValue
    private long id;


    private String number;


    @OneToOne(mappedBy = "phone4", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "details_id")
    private PhoneDetails2 phoneDetails;

    public Phone4() {
    }

    public Phone4(String number) {
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

    public PhoneDetails2 getPhoneDetails() {
        return phoneDetails;
    }

    public void setPhoneDetails(PhoneDetails2 phoneDetails) {
        this.phoneDetails = phoneDetails;
    }

    public void addPhoneDetails(PhoneDetails2 phoneDetails) {
       phoneDetails.setPhone4(this);
         this.phoneDetails = phoneDetails;
    }

    public void removePhoneDetails(PhoneDetails2 phoneDetails) {
        if (phoneDetails != null) {
            phoneDetails.setPhone4(null);
            this.phoneDetails = null;
        }
    }

}
