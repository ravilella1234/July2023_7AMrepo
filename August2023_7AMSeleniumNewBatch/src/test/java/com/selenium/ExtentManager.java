package com.selenium;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends BaseTest
{
	public static ExtentSparkReporter sparkReport;
	public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(report==null)
		{
			report = new ExtentReports();
			
			//init the report folder
			Date d = new Date();
			String reportFolder = d.toString().replace(':', '_')+"//screenshots";
			String screenshotFolderPath = System.getProperty("user.dir")+"//reports//"+reportFolder;
			System.out.println(screenshotFolderPath);
			
			String reportFolderPath = System.getProperty("user.dir")+"//reports//"+d.toString().replace(':', '_');
			
			File f = new File(screenshotFolderPath); 
			f.mkdirs(); // creates dynamic report folder name + screenshot 
			
			sparkReport= new ExtentSparkReporter(reportFolderPath);
			sparkReport.config().setReportName("Production Regression Testing");
			sparkReport.config().setDocumentTitle("Automation Reports");
			sparkReport.config().setTheme(Theme.STANDARD);
			
			report.attachReporter(sparkReport);
		}
		
		return report;
	}

}
