/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.services;

import com.mycompany.carshop.domain.AutomobileType;
import com.mycompany.carshop.repository.AutomobileTypeRepository;
import com.mycompany.carshop.services.AutomobileReviewService;
import com.mycompany.carshop.services.ReviewApprovalService;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Mhumhu
 */
public class AutomobileReviewServiceTest {
    public static ApplicationContext ctx;
    private AutomobileTypeRepository automobileTypeRepository;
    private ReviewApprovalService reviewApprovalService;
    private AutomobileReviewService automobileReviewService;
    
    public AutomobileReviewServiceTest() {
    }
    @Test(enabled = true)
    public void testRatingsApprovalService() {
        
        automobileTypeRepository  = ctx.getBean(AutomobileTypeRepository.class);
        reviewApprovalService = ctx.getBean(ReviewApprovalService.class);
        automobileReviewService = ctx.getBean(AutomobileReviewService.class);
        
         List<AutomobileType> automobileTypes = automobileTypeRepository.findAll();
        
        AutomobileType automobileType = automobileTypes.get(0);
        
        reviewApprovalService.postRating(automobileType.getId(), "Verso 1.6", 4);
        int rating = automobileReviewService.getRating(automobileType.getId(), "Verso 1.6");
        Assert.assertEquals(4, rating);
    }
    
     @Test(enabled = true)
    public void testCustomerReviewApprovalService() {
        
        automobileTypeRepository  = ctx.getBean(AutomobileTypeRepository.class);
        reviewApprovalService = ctx.getBean(ReviewApprovalService.class);
        automobileReviewService = ctx.getBean(AutomobileReviewService.class);
        
        List<AutomobileType> automobileTypes = automobileTypeRepository.findAll();
        
        AutomobileType automobileType = automobileTypes.get(0);
        
        reviewApprovalService.postCustomerReview(automobileType.getId(), "Verso 1.6", "Nice soft ride ;)");
        
        List<String> reviews = automobileReviewService.getReviews(automobileType.getId(), "Verso 1.6");
        Assert.assertEquals("Testing Customer Review 1", "Nice soft ride ;)", reviews.get(0));    
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
