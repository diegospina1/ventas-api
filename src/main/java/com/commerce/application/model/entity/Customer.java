package com.commerce.application.model.entity;

import com.commerce.application.dto.customer.CreateCustomerDto;
import com.commerce.application.dto.customer.UpdateCustomerDto;
import com.commerce.application.helpers.GeographicPointManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity(name = "Customer")
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String document;
    private String firstname;
    private String lastname;
    private Point address;

    public Customer(CreateCustomerDto customerDto) {
        this.document = customerDto.document();
        this.firstname = customerDto.firstname();
        this.lastname = customerDto.lastname();
        this.address = GeographicPointManager.createGeographicPoint(customerDto.address());
    }

    public void actualizar(UpdateCustomerDto customerDto) {
        if (customerDto.firstname() != null){
            this.firstname = customerDto.firstname();
        }
        if (customerDto.lastname() != null){
            this.lastname = customerDto.lastname();
        }
        if (customerDto.address() != null){
            this.address = GeographicPointManager.createGeographicPoint(customerDto.address());
        }
    }
}
