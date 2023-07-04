package com.code.springmvc.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class CollegeStudent implements Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    @NotBlank(message = "firstname is required")
    @Size(min = 2, message = "firstname is too short")
    @Size(max = 20, message = "firstname is too long")
    private String firstname;
    @Column
    @NotBlank(message = "lastname is required")
    @Size(min = 2, message = "lastname is too short")
    @Size(max = 20, message = "lastname is too long")
    private String lastname;

    @Column
    @Min(1900)
    private Integer yearOfBirth;

    @Email(message = "Email is not valid")
    @Column(name="email_address")
    private String emailAddress;

    public CollegeStudent() {

    }

    public CollegeStudent(String firstname, String lastname, String emailAddress, Integer yob) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
        this.yearOfBirth = yob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getFullName() {
        return getFirstname() + " " + getLastname();
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age='" + String.valueOf(yearOfBirth) + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public String studentInformation() {
       return getFullName() + " " + getEmailAddress();
    }
}
