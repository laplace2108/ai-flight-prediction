package com.middleware.services;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.middleware.services.dbconnection.DBConnection;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.repeatHourlyForever;
import static org.quartz.TriggerBuilder.newTrigger;

public class CollectDataScheduler {
	
	public static void main(String[] args) throws SchedulerException {
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		scheduler.start();
		
		JobDetail jobDetail = newJob(DBConnection.class).build();
		
		Trigger trigger = newTrigger().startNow().withSchedule(repeatHourlyForever()).build();
		
		scheduler.scheduleJob(jobDetail, trigger);
	}
}
