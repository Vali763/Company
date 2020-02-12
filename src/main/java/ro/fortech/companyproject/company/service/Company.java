package ro.fortech.companyproject.company.service;


import lombok.Data;
import ro.fortech.companyproject.company.controller.CompanyDto;

@Data
public class Company {
    private String name;
    private String cif;


    public CompanyDto toDto(){
        CompanyDto dto = new CompanyDto();
        dto.setName(name);
        return dto;
    }

    public Company update(CompanyDto dto) {
        this.name = dto.getName();
        return this;
    }
}
