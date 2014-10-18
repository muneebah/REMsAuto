/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.app.exceptions;

/**
 *
 * @author Mhumhu
 */
public class CreditCardRejectionException extends RuntimeException {

    public CreditCardRejectionException(String message) {
        super(message);
    }
    
}
