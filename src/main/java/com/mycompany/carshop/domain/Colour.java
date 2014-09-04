/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author 210188200
 */
@Embeddable
public class Colour implements Serializable{
    private String bodyColour;
    private String interiorColour;

    public String getBodyColour() {
        return bodyColour;
    }

    public void setBodyColour(String bodyColour) {
        this.bodyColour = bodyColour;
    }

    public String getInteriorColour() {
        return interiorColour;
    }

    public void setInteriorColour(String interiorColour) {
        this.interiorColour = interiorColour;
    }
    
    
}
