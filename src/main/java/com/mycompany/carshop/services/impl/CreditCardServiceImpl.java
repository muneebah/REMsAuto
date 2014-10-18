/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.app.exceptions.CreditCardRejectionException;
import com.mycompany.carshop.domain.CreditCard;
import com.mycompany.carshop.repository.CreditCardRepository;
import com.mycompany.carshop.services.CreditCardService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mhumhu
 */
@Service
public class CreditCardServiceImpl  implements CreditCardService{

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public String processPayment(String number, BigDecimal amount, Date expiryDate) {
        
        CreditCard creditCard = getCreditCardByNumber(number);
       
        if (creditCard != null) {
            
            if (amount.doubleValue() > creditCard.getBalance().doubleValue()) {
                throw new CreditCardRejectionException("Insufficient Funds In the Account");
            } else if (expiryDate.after(creditCard.getExpiryDate())) {
                
                throw new CreditCardRejectionException("Sorry Credit Date Expired");
            } else {
                return "APPROVED";
            }
        } else {
            throw new CreditCardRejectionException("Credit Number is Wrong");
        }
    }
    
    private CreditCard getCreditCardByNumber(String number) {
        CreditCard card = null;
        List<CreditCard> creditCards = creditCardRepository.findAll();
        for (CreditCard creditCard : creditCards) {
            if (number.equalsIgnoreCase(creditCard.getCreditNumber())) {
                card = creditCard;
            }
        }
        return card;
    }
    
}
