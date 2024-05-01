package model;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private String surname;
    private Date birthDate;
    private int phone;
    private char gender;


    public User(String firstName, String lastName, String surname, Date birthDate, int phone, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getSurname() {return surname;}
    public Date getBirthDate() {return birthDate;}
    public int getPhone() {return phone;}
    public char getGender() {return gender;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
}
