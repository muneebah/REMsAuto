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
public interface ReviewApprovalService {
    public void postRating(Long automobileType_Id, String automobileTitle, int rating);
    public void postCustomerReview(Long automobileType_Id, String automobileTitle, String customerReview);
    
}
