package com.commerce.application.service.companyBranch;

import com.commerce.application.dto.branch.CompanyBranchDto;
import com.commerce.application.dto.branch.CreateCompanyBranchDto;
import com.commerce.application.dto.branch.UpdateCompanyBranchDto;
import static com.commerce.application.mapper.CompanyBranchMapper.branchMapper;

import com.commerce.application.model.entity.CompanyBranch;
import com.commerce.application.repository.CompanyBranchRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyBranchServiceImpl implements CompanyBranchService{

    private final CompanyBranchRepository repository;

    public CompanyBranchServiceImpl(CompanyBranchRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CompanyBranchDto> listAllBranches() {
        return repository.findAll().stream()
                .map(branchMapper::toBranchDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyBranchDto listOneBranch(Integer id) {
        CompanyBranch branch = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return branchMapper.toBranchDto(branch);
    }

    @Override
    public CompanyBranchDto createBranch(CreateCompanyBranchDto branchDto) {
        CompanyBranch branch = new CompanyBranch(branchDto);
        return branchMapper.toBranchDto(repository.save(branch));
    }

    @Override
    public CompanyBranchDto updateBranch(UpdateCompanyBranchDto branchDto) {
        CompanyBranch branch = repository.findById(branchDto.id())
                .orElseThrow(EntityNotFoundException::new);
        branch.actualizar(branchDto);
        return branchMapper.toBranchDto(repository.save(branch));
    }

    @Override
    public void deleteBranch(Integer id) {

    }
}
