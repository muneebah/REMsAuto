/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.carshop.repository;

import com.mycompany.carshop.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mhumhu
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}
