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
		SchedulerFactory sf = new StdSchedulerFactory();

		Scheduler scheduler = null;

		try{
			scheduler = sf.getScheduler();

			JobDetail job = JobBuilder.newJob(MyTest1.class).withIdentity("job", "jobgroup").build();
			
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "triggerGroup")  
              .withSchedule(CronScheduleBuilder.cronSchedule("* * * 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31 * ?"))  
              .startNow().build();

			scheduler.scheduleJob(job, trigger);

			scheduler.start();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
