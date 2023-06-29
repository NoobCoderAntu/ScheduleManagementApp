package com.anupam.springbootschedulemanagementapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import com.anupam.springbootschedulemanagementapplication.models.ScheduleItem;

public interface ScheduleitemRepository extends CrudRepository <ScheduleItem, Long> {
    

}
