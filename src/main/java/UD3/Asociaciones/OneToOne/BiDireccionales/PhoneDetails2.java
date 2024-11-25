package UD3.Asociaciones.OneToOne.BiDireccionales;

import jakarta.persistence.*;

@Entity
public class PhoneDetails2 {


    @Id
    @GeneratedValue
    private long id;

    private String provider;

    private String technology;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone4_id")
    private Phone4 phone4;

    public PhoneDetails2() {
    }

    public PhoneDetails2(String provider, String technology) {
        this.provider = provider;
        this.technology = technology;
    }

    public long getId() {
        return id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Phone4 getPhone4() {
        return phone4;
    }

    public void setPhone4(Phone4 phone4) {
        this.phone4 = phone4;
    }
}