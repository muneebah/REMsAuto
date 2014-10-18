/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Elton
 */
@Embeddable
public class CustomerContact implements Serializable{
    private String phoneNumber;
    private String cellNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
}
