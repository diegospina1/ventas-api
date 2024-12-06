package com.commerce.application.model.entity;

import com.commerce.application.dto.branch.CreateCompanyBranchDto;
import com.commerce.application.dto.branch.UpdateCompanyBranchDto;
import com.commerce.application.helpers.GeographicPointManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity(name = "CompanyBranch")
@Table(name = "company_branches")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Point location;
    private String name;

    public CompanyBranch(CreateCompanyBranchDto branchDto) {
        this.location = GeographicPointManager.createGeographicPoint(branchDto.location());
        this.name = branchDto.name();
    }

    public void actualizar(UpdateCompanyBranchDto branchDto) {
        if (branchDto.name() != null) {
            this.name = branchDto.name();
        }
        if (branchDto.location() != null) {
            this.location = GeographicPointManager.createGeographicPoint(branchDto.location());
        }
    }
}
