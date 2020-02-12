package ro.fortech.companyproject.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.fortech.companyproject.company.service.Company;
import ro.fortech.companyproject.company.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;


    @RestController
    @RequestMapping("/company")
    public class CompanyController {

        private CompanyService companyService;

        @Autowired
        public CompanyController(CompanyService companyService) {
            this.companyService = companyService;
        }

        @GetMapping("/")
        public List<CompanyDto> getAllCompanies(){
            return companyService.getAllCompanies().stream().map(Company::toDto).collect(Collectors.toList());

        }

        @PostMapping("/")
        public CompanyDto addCompany(@RequestBody Company company){
            return companyService.addCompany(company).toDto();
        }
        @PutMapping("/{existingName}")
        public CompanyDto updateCompany(@PathVariable("existingName") String existingName, @RequestBody Company company){
            return companyService.updateCompany(existingName, company).toDto();
        }
        @DeleteMapping("/{existingName}")
        public String deleteCompany(@PathVariable("existingName") String existingName){
            //return companyService.updateCompany(existingName, company).toDto();
            companyService.deleteCompany(existingName);
            return "Deleted.";
        }
}
