package com.anupam.springbootschedulemanagementapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.anupam.springbootschedulemanagementapplication.models.ScheduleItem;
import com.anupam.springbootschedulemanagementapplication.repositories.ScheduleItemRepository;

@Controller
public class ScheduleItemController {
    
    private final Logger logger = LoggerFactory.getLogger(ScheduleItemController.class);
    
    @Autowired
    private ScheduleItemRepository scheduleItemRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.debug("request to get index");
        ModelAndView modelAndView = new ModelAndView("index");

        //modelAndView.addObject("ScheduleItems", modelAndView.findAll()); 
        return modelAndView;
    }
}
