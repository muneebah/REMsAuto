/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Embeddable;

/**
 *
 * @author Rhulani Baloyi
 */
@Embeddable
public class Accessories implements Serializable{
    private String accessoryNumber;
    private String accessoryName;
    private BigDecimal price;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}
