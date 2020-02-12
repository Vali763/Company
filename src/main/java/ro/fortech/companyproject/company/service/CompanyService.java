package ro.fortech.companyproject.company.service;

import org.springframework.stereotype.Service;
import ro.fortech.companyproject.company.dao.CompanyEntity;
import ro.fortech.companyproject.company.dao.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAll().stream().map(CompanyEntity::toPojo).collect(Collectors.toList());
    }

    public Company addCompany(Company company){
        CompanyEntity newCompany = new CompanyEntity();
        newCompany.update(company);
        return companyRepository.save(newCompany).toPojo();
    }

    public Company updateCompany(String existingName, Company company){
        CompanyEntity saved = companyRepository.findCompanyByName(existingName).orElseThrow(() -> new CompanyNotFoundException(company.getName()));
        saved.update(company);
        return companyRepository.save(saved).toPojo();
    }

    public void deleteCompany(String existingName){
        CompanyEntity deleted = companyRepository.findCompanyByName(existingName).orElseThrow(() -> new CompanyNotFoundException(existingName));
        companyRepository.delete(deleted);
    }


    public Company getById(int id){
        return companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException(String.valueOf(id))).toPojo();
    }
}
