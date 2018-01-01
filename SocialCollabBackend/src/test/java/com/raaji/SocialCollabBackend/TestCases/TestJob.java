package com.raaji.SocialCollabBackend.TestCases;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raaji.SocialCollabBackend.DAO.JobDAO;
import com.raaji.SocialCollabBackend.FileUtil.Date_Time;
import com.raaji.SocialCollabBackend.Model.Job;


public class TestJob 
{
	Logger log = LoggerFactory.getLogger(TestUser.class);
	
	@Autowired
	JobDAO jobDAO;
	
	@Autowired
	Job job;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestJob()
	{	
		context = new AnnotationConfigApplicationContext();
		context.scan("com.raaji.SocialCollabBackend");
		context.refresh();

		jobDAO = (JobDAO) context.getBean("jobDAO");
		job = (Job) context.getBean("job");
	}
	
	public void addJob()
	{
		job.setTitle("This is my Job Project");
		job.setUsername("raaji");
		job.setStatus('Y');
		job.setPosition("Developers");
		job.setCompany("TCS");
		job.setDescription("Software Engineer reqd freshers from 2016/2017 batch. Prefered Branch : CS/ IT");
		job.setSalary("Rs. 3.75 LPA");
		job.setLocation("INDIA");
		job.setQ_10("88.66%");
		job.setQ_12("92.7%");
		job.setQ_ug("83%");
		
		Date_Time dt = new Date_Time();
		String date = dt.getDateTime();
		job.setDate(date);
		job.setVacancy(100);
		
		jobDAO.addJob(job);
		System.out.println("Job has been added");
	}
	
	public void listJob()
	{
		List<Job> jobs = jobDAO.listJobs();
		int n = jobs.size();
		System.out.println("Size "+n);
		for(int i=0;i<n;i++)
		{
			System.out.println("Name -"+jobs.get(i).getTitle()+"\t Company"+jobs.get(i).getCompany()+"\t Position "+jobs.get(i).getPosition());
		}
	}
	
	public void deleteJob()
	{
		int id = 39;
		jobDAO.deleteJob(id);
		System.out.println("Job deleted");
	}
	
	public void inValidate()
	{
		int id = 40;
		jobDAO.invalidateJob(id);
		System.out.println("Invalidate Success");
	}
	
	public void getJob()
	{
		String name = "My Second Job";
		Job job = jobDAO.getJob(name);
		System.out.println("JOB Description");
		System.out.println("Name: "+job.getTitle()+"\t Company: "+job.getCompany()+"\t Position: "+job.getPosition());	
	}
	
	public static void main(String[] args) 
	{
		TestJob tj = new TestJob();
	tj.addJob();
	tj.listJob();
	tj.deleteJob();
//		tj.inValidate();
//		tj.getJob();
	}
}
