/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Mhumhu
 */
public interface CreditCardService {
    public String processPayment(String number, BigDecimal amount,Date expiryDate);
}
