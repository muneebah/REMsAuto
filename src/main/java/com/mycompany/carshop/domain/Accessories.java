/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Embeddable;

/**
 *
 * @author Mhumhu
 */
@Embeddable
public class Accessories implements Serializable{
    private String accessoryNumber;
    private String accessoryName;
    private BigDecimal unitPrice;

    public String getAccessoryNumber() {
        return accessoryNumber;
    }

    public void setAccessoryNumber(String accessoryNumber) {
        this.accessoryNumber = accessoryNumber;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
}
