/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.app.exceptions.CustomerReviewAddingPendingException;
import com.mycompany.carshop.app.exceptions.MarketInformationPendingException;
import com.mycompany.carshop.app.exceptions.PostingReviewRatingException;
import com.mycompany.carshop.domain.Automobile;
import com.mycompany.carshop.domain.AutomobileType;
import com.mycompany.carshop.domain.MarketingInformation;
import com.mycompany.carshop.domain.Review;
import com.mycompany.carshop.repository.AutomobileTypeRepository;
import com.mycompany.carshop.services.ReviewApprovalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mhumhu
 */
@Service
public class ReviewApprovalServiceImpl implements ReviewApprovalService{

    @Autowired
    AutomobileTypeRepository automobileTypeRepository;
    
    private final String testNull = null;
    
    @Override
    public void postRating(Long automobileType_Id, String automobileTitle, int rating) {
        
        AutomobileType autoType = automobileTypeRepository.findOne(automobileType_Id);
        List<Automobile> automobiles = autoType.getAutomobiles();
        
        for(Automobile automobile : automobiles) {
            if (automobileTitle.equals(automobile.getAutoName())) {
                MarketingInformation marketInfo = automobile.getMarketingInformation();
                
                if ("PENDING".equals(marketInfo.getStatusOfInformation())) {
                    Review review = marketInfo.getReview();
                    review.setRating(rating);
                    
                    automobiles.remove(automobile);
                    marketInfo.setReview(review);
                    marketInfo.setStatusOfInformation("RATING / CUSTOMER PENDING");
                    automobile.setMarketingInformation(marketInfo);
                    automobiles.add(automobile);
                    autoType.setAutomobiles(automobiles);
                    automobileTypeRepository.save(autoType);
                } else {
                    throw new PostingReviewRatingException("Already rated. . . ");
                }
                
            }
        }
    }

    @Override
    public void postCustomerReview(Long automobileType_Id, String automobileTitle, String customerReview) {
        AutomobileType autoType = automobileTypeRepository.findOne(automobileType_Id);
        List<Automobile> automobiles = autoType.getAutomobiles();
        
        for(Automobile automobile : automobiles) {
            if (automobileTitle.equals(automobile.getAutoName())) {
                MarketingInformation marketInfo = automobile.getMarketingInformation();
                
                if ("RATING / CUSTOMER PENDING".equals(marketInfo.getStatusOfInformation())) {
                    Review review = marketInfo.getReview();
                    
                    if(testNull.equals(review.getDescription() == null)) {
                        throw new CustomerReviewAddingPendingException("Customer review full. . . ");
                    } else {
                        setCustomerReview(review, customerReview);
                        
                        automobiles.remove(automobile);
                        marketInfo.setReview(review);
                        marketInfo.setStatusOfInformation("COMPLETE");
                        automobile.setMarketingInformation(marketInfo);
                        automobiles.add(automobile);
                        autoType.setAutomobiles(automobiles);
                        automobileTypeRepository.save(autoType);
                    }
                } else {
                    throw new MarketInformationPendingException("Rating not posted or complete. . . ");
                }
            }
        }
    }
    
    public void setCustomerReview(Review review, String customerReview) {
        if(testNull.equals(review.getDescription() == null)) {
            review.setDescription(customerReview);
        } 
    }
}
