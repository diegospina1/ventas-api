package com.commerce.application.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Entity(name = "CompanyBranch")
@Table(name = "company_branches")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CompanyBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Point location;
    private String name;
}
