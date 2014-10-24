/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carshop.presentation.controllers;

import com.mycompany.carshop.presentation.models.Welcome;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mhumhu
 */
@Controller
public class IndexController {
    @RequestMapping({"/"})
    public String homePage(Model model) {
        
         Welcome message = new Welcome();
         message.setWelcome("Welcome to REM's Auto App");
         message.setToday(new Date());
         model.addAttribute("msg", message);
        return "index";
    }
    
}
