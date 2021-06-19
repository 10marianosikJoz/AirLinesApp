package com.example.airlines.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class UserDTO {

    private String firstName;
    private String lastName;
    @Length(min = 8, max = 15)
    private String password;
    @Length(min = 8, max = 15)
    private String confirmPassword;
    @Email
    private String email;
    private Boolean blocked = false;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Boolean getBlocked() {
        return blocked;
    }
}
