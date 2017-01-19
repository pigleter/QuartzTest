package com.quartztest;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class ScheduleApp {
	public static void main(String[] args) {
		SchedulerFactory schedulerfactory = new StdSchedulerFactory();  
	       Scheduler scheduler = null;  
	       try{
	    	   
	    	   scheduler = schedulerfactory.getScheduler();
	           
	           JobDetail job = JobBuilder.newJob(MyTestJob.class).withIdentity("job1", "jgroup1").build();
	           
	           Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")  
	              .withSchedule(CronScheduleBuilder.cronSchedule("0,30 * * * * ? *"))  
	              .startNow().build();
	           
	           
	           scheduler.scheduleJob(job, trigger);
	           scheduler.start();
	             
	       }catch(Exception e){  
	           e.printStackTrace();  
	       }  
	}
}
