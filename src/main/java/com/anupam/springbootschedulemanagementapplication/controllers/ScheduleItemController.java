package com.anupam.springbootschedulemanagementapplication.controllers;

import java.time.Instant;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anupam.springbootschedulemanagementapplication.models.ScheduleItem;
import com.anupam.springbootschedulemanagementapplication.repositories.ScheduleItemRepository;

import jakarta.validation.Valid;

@Controller
public class ScheduleItemController {
    
    private final Logger logger = LoggerFactory.getLogger(ScheduleItemController.class);
    
    @Autowired
    private ScheduleItemRepository scheduleItemRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.debug("request to get index");
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("ScheduleItems", scheduleItemRepository.findAll()); 
        modelAndView.addObject("Today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return modelAndView;
    }
    
    @PostMapping("/schedule")
    public String creteScheduleItem (@Valid ScheduleItem scheduleItem, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "add-schedule-item";
        }

        scheduleItem.setCreatedDate(Instant.now());
        scheduleItem.setModifiedDate(Instant.now());
        scheduleItemRepository.save(scheduleItem);
        return "redirect:/";
    }

    @PostMapping("/schedule/{id}")
    public String updateScheduleItem (@PathVariable("id") long id, @Valid ScheduleItem scheduleItem, BindingResult result, Model model){
        if(result.hasErrors()){
            scheduleItem.setId(id);
            return "update-schedule-item";
        }

        scheduleItem.setModifiedDate(Instant.now());
        scheduleItemRepository.save(scheduleItem);
        return "redirect:/";

    }

}
