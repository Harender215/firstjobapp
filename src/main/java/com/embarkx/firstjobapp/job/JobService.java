package com.embarkx.firstjobapp.job;

import java.util.List;

public interface JobService {
	
	List<Job> findAll();
	
	void createJob(Job job);
	
	Job getJobById(Long id);

	void deleteJobById(Long id);

	void updateJobById(Long id, Job updatedJob);

}
