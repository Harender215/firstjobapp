package com.embarkx.firstjobapp.company;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@GetMapping
	ResponseEntity<List<Company>> fetchAllCompanies() {
		return new ResponseEntity<>(companyService.fetchAllCompanies(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<String> UpdateCompany(@PathVariable Long id, @RequestBody Company company) {
		companyService.updateCompany(company, id);
		return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
	}
	
	@PostMapping
	ResponseEntity<String> createCompany(@RequestBody Company company) {
		companyService.createCompany(company);
		return new ResponseEntity<>("Company created successfully", HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteCompany(@PathVariable Long id) {
		boolean isDeleted = companyService.deleteCompanyById(id);
		if(isDeleted) {
			return new ResponseEntity<>("Company Deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Company> getCompany(@PathVariable Long id) {
		Company company = companyService.getCompanyById(id);
		if(company != null) {
			return new ResponseEntity<>(company, HttpStatus.OK);			
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}






