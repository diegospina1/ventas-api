package com.commerce.application.service.companyBranch;

import com.commerce.application.dto.branch.CompanyBranchDto;
import com.commerce.application.dto.branch.CreateCompanyBranchDto;
import com.commerce.application.dto.branch.UpdateCompanyBranchDto;
import jakarta.validation.Valid;

import java.util.List;

public interface CompanyBranchService {
    List<CompanyBranchDto> listAllBranches();

    CompanyBranchDto listOneBranch(Integer id);

    CompanyBranchDto createBranch(@Valid CreateCompanyBranchDto branchDto);

    CompanyBranchDto updateBranch(@Valid UpdateCompanyBranchDto branchDto);

    void deleteBranch(Integer id);
}
