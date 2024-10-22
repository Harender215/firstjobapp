package com.embarkx.firstjobapp.company;

import java.util.List;

public interface CompanyService {
	
	List<Company> fetchAllCompanies();
	
	void createCompany(Company company);
	
	boolean updateCompany(Company company, Long id);
	
	boolean deleteCompanyById(Long id);
	
	Company getCompanyById(Long id);
	
}
