package com.commerce.application.service.companyBranch;

import com.commerce.application.model.entity.CompanyBranch;

public interface CompanyBranchSearch {
    CompanyBranch findById(Integer id);
    Boolean existsById(Integer id);
}
