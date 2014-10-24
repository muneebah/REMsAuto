/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.presentation.models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mhumhu
 */
public class Welcome implements Serializable
{
    private String welcome;
    private Date today;

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }
    
    
    
}
