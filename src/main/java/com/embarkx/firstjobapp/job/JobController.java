package com.embarkx.firstjobapp.job;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	private JobService jobService; 
	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}
	
	@GetMapping
	public ResponseEntity<List<Job>> findAll() {	
		return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK) ;
	}
	
	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("job Added successfully", HttpStatus.OK) ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		Job job = jobService.getJobById(id);
		System.out.println("inside getJobBYId");
		if(job != null)
			return new ResponseEntity<>(job, HttpStatus.OK);
		return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
		jobService.deleteJobById(id);
		return new ResponseEntity<String>("job deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job) {
		jobService.updateJobById(id, job);
		return new ResponseEntity<String>("job update successfully", HttpStatus.OK);
	}
	
}







