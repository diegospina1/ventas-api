package com.commerce.application.controller;

import com.commerce.application.dto.branch.CompanyBranchDto;
import com.commerce.application.dto.branch.CreateCompanyBranchDto;
import com.commerce.application.dto.branch.UpdateCompanyBranchDto;
import com.commerce.application.service.companyBranch.CompanyBranchService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class CompanyBranchController {

    private final CompanyBranchService branchService;

    public CompanyBranchController(CompanyBranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyBranchDto>> listAllBranches(){
        return ResponseEntity.ok(branchService.listAllBranches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyBranchDto> listOneBranch(@PathVariable("id") Integer id){
        return ResponseEntity.ok(branchService.listOneBranch(id));
    }

    @PostMapping
    public ResponseEntity<CompanyBranchDto> createBranch(@RequestBody @Valid CreateCompanyBranchDto branchDto){
        return ResponseEntity.ok(branchService.createBranch(branchDto));
    }

    @PutMapping
    public ResponseEntity<CompanyBranchDto> updateBranch(@RequestBody @Valid UpdateCompanyBranchDto branchDto){
        return ResponseEntity.ok(branchService.updateBranch(branchDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable("id") Integer id){
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }


}
