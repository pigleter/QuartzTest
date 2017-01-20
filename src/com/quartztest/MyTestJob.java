package com.quartztest;

import java.util.Date;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyTestJob implements org.quartz.Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		System.out.println("测试Quartz "+new Date());
		
		//String[] params = {"3007", "L1", "S008", "H2"};
		
		Trans trans = null;  
        try {  

            KettleEnvironment.init();
            EnvUtil.environmentInit();  
            TransMeta transMeta = new TransMeta("C:\\Users\\ivan.yu\\Desktop\\test.ktr"); 

            trans = new Trans(transMeta);
            
            trans.setParameterValue("BUKRS", "3007");
            trans.setParameterValue("SPART", "L1");
            trans.setParameterValue("VKORG", "S008");
            trans.setParameterValue("VTWEG", "H2");

            trans.execute(null);;
            // 等待转换执行结束  
            trans.waitUntilFinished();  
            // 抛出异常  
            if (trans.getErrors() > 0) {  
                throw new Exception(  
                        "There are errors during transformation exception!(传输过程中发生异常)");  
            }  
        } catch (Exception e) {
            e.printStackTrace();  
        }  

	}
	
	public static void runJob(String[] params, String jobPath) {  
        
	}

}
