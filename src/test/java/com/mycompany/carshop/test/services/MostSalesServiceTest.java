/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.services;

import com.mycompany.carshop.domain.AutomobileType;
import com.mycompany.carshop.services.MostSalesService;
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
public class MostSalesServiceTest {
    private static ApplicationContext ctx;
     private MostSalesService mostSalesService;
    
    public MostSalesServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = false)
    public void testMostSalesService() {
        
        mostSalesService = ctx.getBean(MostSalesService.class);
        
        AutomobileType autotype = mostSalesService.getMostSalesAutomobile();
        
        Assert.assertEquals("Sedan", autotype.getAutoType());
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
