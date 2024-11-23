package UD3;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ANOTHER_USER")
public class User1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;


    private Direccion direccion;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "via", column = @Column(name = "CALLE_FACTURACION")),
            @AttributeOverride(name = "codigoPostal", column = @Column(name = "CP_FACTURACION", length = 5)),
            @AttributeOverride(name = "poblacion", column = @Column(name = "POBLACION_FACTURACION")),
            @AttributeOverride(name = "provincia", column = @Column(name = "PROVINCIA_FACTURACION"))
    })

    private Direccion billingAddress;


    public User1() {
    }

    public long getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Direccion billingAddress) {
        this.billingAddress = billingAddress;
    }
}

