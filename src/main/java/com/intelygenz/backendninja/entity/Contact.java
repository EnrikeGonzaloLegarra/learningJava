package com.intelygenz.backendninja.entity;


import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @GeneratedValue()
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "city")
    private String city;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Contact(int id, String firstname, String lastname, String telephone, String city) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.city = city;
    }

    // Constructor por defecto para que hibernate pueda gestionar estas entitys
    // Tenemos que añardir siempre el contructor por defecto en las entitis
    public Contact() {
    }


}
