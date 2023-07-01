package com.anupam.springbootschedulemanagementapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.anupam.springbootschedulemanagementapplication.models.ScheduleItem;
import com.anupam.springbootschedulemanagementapplication.repositories.ScheduleItemRepository;

@Controller
public class ScheduleFormController {
    
    private final Logger logger = LoggerFactory.getLogger(ScheduleFormController.class);

    @Autowired
    private ScheduleItemRepository scheduleItemRepository;

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
         
        ScheduleItem scheduleItem = scheduleItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ScheduleItem id : "+id + " not found"));

        model.addAttribute("Schedule", scheduleItem);
        return "update-schedule-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteScheduleItem (@PathVariable("id") long id, Model model) {
        
        ScheduleItem scheduleItem = scheduleItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ScheduleItem id : "+id + " not found"));
        
        scheduleItemRepository.delete(scheduleItem);
        return "redirect:/";
    }

}
