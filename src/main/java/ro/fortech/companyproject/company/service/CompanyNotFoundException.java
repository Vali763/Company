package ro.fortech.companyproject.company.service;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(String id){super(id);}
}
