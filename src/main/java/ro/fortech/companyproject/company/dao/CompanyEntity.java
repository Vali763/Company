package ro.fortech.companyproject.company.dao;

import lombok.Data;
import ro.fortech.companyproject.company.service.Company;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;

@Data
@Entity
@Table
public class CompanyEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name="name",unique = true,nullable = false)
    private String name;
    private String cif;

    public Company toPojo(){
        Company pojo = new Company();
        pojo.setName(name);
        pojo.setCif(cif);
        return pojo;
        //"adaasasfas"

    }
}
