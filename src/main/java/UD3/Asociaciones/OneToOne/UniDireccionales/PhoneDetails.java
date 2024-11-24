package UD3.Asociaciones.OneToOne.UniDireccionales;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PhoneDetails {


    @Id
    @GeneratedValue
    private long id;

    private String provider;

    private String technology;

    public PhoneDetails() {
    }

    public PhoneDetails(String provider, String technology) {
        this.provider = provider;
        this.technology = technology;
    }
}
