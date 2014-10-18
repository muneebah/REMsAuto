/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services;

import java.math.BigDecimal;

/**
 *
 * @author Mhumhu
 */
public interface OrderAmountService {
    public BigDecimal calculateOrderAmount(Long order_Id);
    
}
