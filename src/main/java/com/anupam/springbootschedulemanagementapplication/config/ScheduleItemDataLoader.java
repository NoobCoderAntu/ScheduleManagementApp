package com.anupam.springbootschedulemanagementapplication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anupam.springbootschedulemanagementapplication.models.ScheduleItem;
import com.anupam.springbootschedulemanagementapplication.repositories.ScheduleItemRepository;


@Component
public class ScheduleItemDataLoader implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(ScheduleItemDataLoader.class);

    @Autowired
    ScheduleItemRepository scheduleItemRepository ;

    @Override
    public void run ( String... args ) throws Exception {
        loadSeedData();
    }

    private void loadSeedData (){
        if(scheduleItemRepository.count() == 0){
            ScheduleItem scheduleItem1 = new ScheduleItem("get the milk");
            ScheduleItem scheduleItem2 = new ScheduleItem("rake the leave");

            scheduleItemRepository.save(scheduleItem1);
            scheduleItemRepository.save(scheduleItem2);
        }
        logger.info("Number of Schedule Items : {}", scheduleItemRepository.count());
    }

}
