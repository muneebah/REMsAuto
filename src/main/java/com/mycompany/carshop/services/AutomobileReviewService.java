/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services;

import java.util.List;

/**
 *
 * @author Mhumhu
 */
public interface AutomobileReviewService {
    public int getRating(Long automobileType_Id, String automobileTitle);
    public List<String> getReviews(Long automobileType_Id, String automobileTitle);
    
}
