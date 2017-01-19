package com.quartztest;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyTest1 implements org.quartz.Job {
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		System.out.println("测试1" + "   " + new Date());
	}
}
