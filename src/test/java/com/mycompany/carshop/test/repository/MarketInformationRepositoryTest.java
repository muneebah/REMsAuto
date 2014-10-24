/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.test.repository;

import com.mycompany.carshop.domain.MarketingInformation;
import com.mycompany.carshop.domain.Review;
import com.mycompany.carshop.repository.MarketInfomationRepository;
import com.mycompany.carshop.repository.ReviewRepository;
import com.mycompany.carshop.test.ConnectionConfigTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Mhumhu
 */
public class MarketInformationRepositoryTest {
     private MarketInfomationRepository marketRepository;
     private ReviewRepository reviewRepo;
      private static ApplicationContext ctx;
       private Long id;
    
    public MarketInformationRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createMarketingInfo() {
        marketRepository = ctx.getBean(MarketInfomationRepository.class);
         reviewRepo = ctx.getBean(ReviewRepository.class);
                
         Review review = new Review.Builder("Great car, love it")
                                    .rating(10)
                                    .build();
         reviewRepo.save(review);
         
         MarketingInformation marketingInformation = new MarketingInformation.Builder("PENDING")      
                                                                .review(review)
                                                                .build();
        
             
     marketRepository.save(marketingInformation);
     id = marketingInformation.getId();
    Assert.assertNotNull(marketingInformation);
     
     
    }

    @Test(dependsOnMethods = "createMarketingInfo", enabled = true)
    public void readMarketingInfo() {
        marketRepository = ctx.getBean(MarketInfomationRepository.class);
        
        MarketingInformation info = marketRepository.findOne(id);
        Assert.assertEquals(info.getStatusOfInformation(),"PENDING");
    }

    @Test(dependsOnMethods = "readMarketingInfo", enabled = true)
    private void updateMarketingInfo() {
         marketRepository = ctx.getBean(MarketInfomationRepository.class);
        
       
        MarketingInformation info = marketRepository.findOne(id);
        MarketingInformation updateInfo = new MarketingInformation.Builder("PENDING")
                .MarketingInformation(info)
                .build();
        
        marketRepository.save(updateInfo);
        
        MarketingInformation newInfo = marketRepository.findOne(id);
        Assert.assertEquals(newInfo.getStatusOfInformation(), "PENDING");

    }

    @Test(dependsOnMethods = "updateMarketingInfo", enabled = false)
    private void deleteMarketingInfo() {

        marketRepository = ctx.getBean(MarketInfomationRepository.class);
       
        MarketingInformation info = marketRepository.findOne(id);
        marketRepository.delete(info);
        MarketingInformation deletedInfo = marketRepository.findOne(id);
        
        Assert.assertNull(deletedInfo);
    }
    

    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = (ApplicationContext) new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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
