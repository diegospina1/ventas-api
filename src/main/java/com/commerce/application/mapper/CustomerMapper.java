package com.commerce.application.mapper;

import com.commerce.application.dto.customer.CustomerDto;
import com.commerce.application.helpers.GeographicPointManager;
import com.commerce.application.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {GeographicPointManager.class})
public interface CustomerMapper {

    CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "address", expression = "java(GeographicPointManager.getCoordinate(customer.getAddress()))")
    CustomerDto toCustomerDto(Customer customer);
    @Mapping(target = "address", expression = "java(GeographicPointManager.createGeographicPoint(customerDto.address()))")
    Customer toCustomer(CustomerDto customerDto);
}
