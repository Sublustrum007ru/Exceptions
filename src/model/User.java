package model;

import util.Validator;;import java.text.ParseException;

public class User implements Comparable {
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

    public User() {
    }


    //
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {return lastName;}
    public String getSurname() {return surname;}
    public String getBirthDate() {return birthDate;}
    public String getPhone() {return phone;}
    public String getGender() {return gender;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User createUser(String[] line) throws ParseException {
        Validator vl = new Validator();
        setFirstName(vl.isAlpha(line[0], "F"));
        setLastName(vl.isAlpha(line[1], "L"));
        setSurname(vl.isAlpha(line[2], "S"));
        setBirthDate(vl.isDate(line[3]));
        setPhone(vl.isNumeric(line[4]));
        setGender(vl.isGender(line[5].toLowerCase()));
        return this;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>\n", firstName, lastName, surname, birthDate, phone, gender);
    }

    @Override
    public int compareTo(Object o) {
        if (this.getFirstName().equals(((User) o).getFirstName())) {
            if (this.getLastName().equals(((User) o).getLastName())) {
                if (this.getSurname().equals(((User) o).getSurname())) {
                    if (this.getBirthDate().equals(((User) o).getBirthDate())) {
                        if (this.getPhone().equals(((User) o).getPhone())) {
                            if (this.getGender().equals(((User) o).getGender())) {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        User user = (User) o;
        return CharSequence.compare(this.getFirstName(), user.getFirstName()) == 0
                && CharSequence.compare(this.getLastName(), user.getLastName()) == 0
                && CharSequence.compare(this.getSurname(), user.getSurname()) == 0
                && CharSequence.compare(this.getBirthDate(), user.getBirthDate()) == 0
                && CharSequence.compare(this.getPhone(), user.getPhone()) == 0
                && CharSequence.compare(this.getGender(), user.getGender()) == 0;
    }


}
