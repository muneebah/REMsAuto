/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.domain.Automobile;
import com.mycompany.carshop.domain.Order;
import com.mycompany.carshop.domain.OrderItem;
import com.mycompany.carshop.repository.OrderRepository;
import com.mycompany.carshop.services.OrderAmountService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mhumhu
 */
@Service
public class OrderAmountServiceImpl implements OrderAmountService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public BigDecimal calculateOrderAmount(Long order_Id) {
        double total = 0.00;
        
        Order order = orderRepository.findOne(order_Id);
        List<OrderItem> orderItems = order.getItem();
        
        for (OrderItem orderItem : orderItems) {
            Automobile automobile = orderItem.getAutomobile();
            double unitPrice = automobile.getUnitPrice().doubleValue();
            
            int quantity = orderItem.getQuantity();
            
            unitPrice *= quantity;
            
            total += unitPrice;
        }
        return new BigDecimal(total);
    } 
    
}
