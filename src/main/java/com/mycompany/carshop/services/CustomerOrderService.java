/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services;

import java.util.Map;

/**
 *
 * @author Mhumhu
 */
public interface CustomerOrderService {
     public void orderAutomobile(Long Id, Map<String, String> automobileDetails, int quantity);
    
}
