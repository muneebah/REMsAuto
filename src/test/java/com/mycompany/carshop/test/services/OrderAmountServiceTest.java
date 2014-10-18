/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.test.services;

import com.mycompany.carshop.domain.Order;
import com.mycompany.carshop.repository.OrderRepository;
import com.mycompany.carshop.services.OrderAmountService;
import com.mycompany.carshop.test.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.List;
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
public class OrderAmountServiceTest {
     private static ApplicationContext ctx;
    private OrderRepository orderRepository;
    private OrderAmountService orderAmountService;
    
    
    public OrderAmountServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testOrderAmountService() {
    
         orderRepository = ctx.getBean(OrderRepository.class);
         orderAmountService = ctx.getBean(OrderAmountService.class);
         
         List<Order> orders = orderRepository.findAll();
        
        Order order  = orders.get(0);
        int orderNumber = order.getOrderNumber();           
        Assert.assertNotNull(orderNumber);
         
        Assert.assertEquals(new BigDecimal(200000.00), orderAmountService.calculateOrderAmount(order.getId()));
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
