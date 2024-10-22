package com.embarkx.firstjobapp.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embarkx.firstjobapp.company.Company;
import com.embarkx.firstjobapp.company.CompanyRepository;
import com.embarkx.firstjobapp.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	CompanyRepository companyRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	@Override
	public List<Company> fetchAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public boolean updateCompany(Company updatedCompany, Long id) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if(companyOptional.isPresent()) {
			Company company = companyOptional.get();
			company.setName(updatedCompany.getName());
			company.setJobs(updatedCompany.getJobs());
			company.setDescription(updatedCompany.getDescription());
			companyRepository.save(updatedCompany);
			return true;
		}
		return false;
	}

	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		if(companyRepository.existsById(id)) {			
			companyRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
		
	}

}
