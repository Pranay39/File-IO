package com.programs.File.IO.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Employee {
    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "country")
    private String country;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "no")
    private Integer no;


//    private LocalDateTime date;


    public Employee() {

    }

    public Employee(Integer no, String firstName, String lastName, String gender, String country, Integer age, LocalDateTime date, Integer id) {
        this.no = no;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.age = age;
//        this.date = date;
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public LocalDateTime getDate() {
//        return date;
//    }

//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
