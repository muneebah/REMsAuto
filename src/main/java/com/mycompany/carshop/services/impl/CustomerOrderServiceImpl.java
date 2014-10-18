/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.services.impl;

import com.mycompany.carshop.app.exceptions.AutomobileNotFoundException;
import com.mycompany.carshop.domain.Automobile;
import com.mycompany.carshop.domain.AutomobileType;
import com.mycompany.carshop.domain.Order;
import com.mycompany.carshop.domain.OrderItem;
import com.mycompany.carshop.repository.AutomobileTypeRepository;
import com.mycompany.carshop.repository.OrderRepository;
import com.mycompany.carshop.services.CustomerOrderService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mhumhu
 */
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
    
    @Autowired
    private AutomobileTypeRepository automobileTypeRepository;
    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public void orderAutomobile(Long Id, Map<String, String> automobileDetails, int quantity) {
        AutomobileType automobileType = automobileTypeRepository.findOne(Id);
        List<Automobile> automobiles = automobileType.getAutomobiles();

        for (Automobile automobile2 : automobiles) {
            if (automobileDetails.get("autoName").equals(automobile2.getAutoName())) {
                
                Order order = orderRepository.findOne(Id);
                List<OrderItem> orderItems = order.getItem();
                
                OrderItem orderItem = new OrderItem.Builder(quantity)
                                        .automobile(automobile2)
                                        .build();
                
                orderItems.add(orderItem);
                order.setItem(orderItems);
                
                orderRepository.save(order);
            } else {
                throw new AutomobileNotFoundException("Automobile not found. . .");
            }
        }
    }
    
}
