/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.app.exceptions.MarketInformationPendingException;
import com.mycompany.carshop.domain.Automobile;
import com.mycompany.carshop.domain.AutomobileType;
import com.mycompany.carshop.domain.MarketingInformation;
import com.mycompany.carshop.domain.Review;
import com.mycompany.carshop.repository.AutomobileTypeRepository;
import com.mycompany.carshop.services.AutomobileReviewService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mhumhu
 */
@Service
public class AutomobileReviewServiceImpl implements AutomobileReviewService{

    @Autowired
    AutomobileTypeRepository automobileTypeRepository;
    
    @Override
    public int getRating(Long automobileType_Id, String automobileTitle) {
        int rating = -1;
        
        AutomobileType autoType = automobileTypeRepository.findOne(automobileType_Id);
        List<Automobile> automobiles = autoType.getAutomobiles();
        
        for(Automobile automobile : automobiles) {
            if (automobileTitle.equals(automobile.getAutoName())) {
                MarketingInformation marketInfo = automobile.getMarketingInformation();
                
                if (!"PENDING".equals(marketInfo.getStatusOfInformation())) {
                    Review review = marketInfo.getReview();
                    rating = review.getRating();
                } else {
                    throw new MarketInformationPendingException("Marketing information pending. . . ");
                }
            }
        }
        return rating;
    }

    @Override
    public List<String> getReviews(Long automobileType_Id, String automobileTitle) {
        List<String> reviews = new ArrayList<String>();
        
        AutomobileType autoType = automobileTypeRepository.findOne(automobileType_Id);
        List<Automobile> automobiles = autoType.getAutomobiles();
        
        for(Automobile automobile : automobiles) {
            if (automobileTitle.equals(automobile.getAutoName())) {
                MarketingInformation marketInfo = automobile.getMarketingInformation();
                
                if ("COMPLETE".equals(marketInfo.getStatusOfInformation())) {
                    Review review = marketInfo.getReview();
                    reviews.add(review.getDescription());
                    }
                else {
                    throw new MarketInformationPendingException("Marketing information pending. . . ");
                }
            }
        }
        return reviews;
    }
    
}
