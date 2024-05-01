package model;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private String surname;
    private String birthDate;
    private String phone;
    private String gender;


    public User(String firstName, String lastName, String surname, String birthDate, String phone, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
    }
//
//    public String getFirstName() {return firstName;}
//    public String getLastName() {return lastName;}
//    public String getSurname() {return surname;}
//    public String getBirthDate() {return birthDate;}
//    public String getPhone() {return phone;}
//    public String getGender() {return gender;}
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//    public void setBirthDate(String birthDate) {
//        this.birthDate = birthDate;
//    }
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    @Override
    public String toString(){
        return String.format("<%s><%s><%s><%s><%s><%s>\n", firstName, lastName, surname, birthDate, phone, gender);
    }
}
