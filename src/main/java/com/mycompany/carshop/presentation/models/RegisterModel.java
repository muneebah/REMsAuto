/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.presentation.models;

import java.io.Serializable;

/**
 *
 * @author Mhumhu
 */
public class RegisterModel implements Serializable{
    
    private String firstname;
    private String lastname;
    private String password;
    private String compassword;
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompassword() {
        return compassword;
    }

    public void setCompassword(String compassword) {
        this.compassword = compassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
