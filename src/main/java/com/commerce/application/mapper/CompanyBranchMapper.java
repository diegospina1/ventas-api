package com.commerce.application.mapper;

import com.commerce.application.dto.branch.CompanyBranchDto;
import com.commerce.application.helpers.GeographicPointManager;
import com.commerce.application.model.entity.CompanyBranch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {GeographicPointManager.class})
public interface CompanyBranchMapper {

    CompanyBranchMapper branchMapper = Mappers.getMapper(CompanyBranchMapper.class);

    @Mapping(target = "location", expression = "java(GeographicPointManager.getCoordinate(branch.getLocation()))")
    CompanyBranchDto toBranchDto(CompanyBranch branch);

    @Mapping(target = "location", expression = "java(GeographicPointManager.createGeographicPoint(branchDto.location()))")
    CompanyBranch toBranch(CompanyBranchDto branchDto);
}
