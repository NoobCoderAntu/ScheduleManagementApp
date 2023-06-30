package com.anupam.springbootschedulemanagementapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import com.anupam.springbootschedulemanagementapplication.models.ScheduleItem;

public interface ScheduleItemRepository extends CrudRepository <ScheduleItem, Long> {
    

}
