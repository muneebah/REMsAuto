/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services;

/**
 *
 * @author Mhumhu
 */
public interface CustomerInfoService {
    public String getFullName(Long customerID);
    public String getStreetAddress(Long customerID);
    public String getCellNumber(Long customerID);
    
}
