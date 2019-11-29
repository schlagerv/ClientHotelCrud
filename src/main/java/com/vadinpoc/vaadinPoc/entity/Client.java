package com.vadinpoc.vaadinPoc.entity;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cpf;
    private String name;
    private boolean active;
    private String address;
    private String email;
    int age;
    String mothername;
    String fathername;


    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long clientId) {
        this.id = clientId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", mothername='" + mothername + '\'' +
                ", fathername='" + fathername + '\'' +
                '}';
    }

    public String[] toCSV() {
        return new String[]{String.valueOf(id), name, cpf, email, booleanToString(active)};

    }
    public String booleanToString(boolean status){
        if(status)
            return "1";
        else
            return "0";
    }

}