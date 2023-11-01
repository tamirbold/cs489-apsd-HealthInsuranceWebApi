package edu.miu.cs.cs489.project.healthinsuranceapp.controller;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Coverage;
import edu.miu.cs.cs489.project.healthinsuranceapp.model.Billing;
import edu.miu.cs.cs489.project.healthinsuranceapp.service.CoverageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/coverages")
public class CoverageController {
    private CoverageService coverageService;
    public CoverageController(CoverageService coverageService){
        this.coverageService = coverageService;
    }
    @GetMapping(value = "/list")
    public List<Coverage> getAllCoverages(){
        return coverageService.getAllCoverages();
    }
    @GetMapping(value = "/get/{coverageId}")
    public  Coverage getCoverageById(@PathVariable Long coverageId){
        return coverageService.getCoverageById(coverageId);
    }
    @PutMapping(value = "/update/{coverageId}")
    public Coverage updateCoverage(@PathVariable Long coverageId, @RequestBody Coverage coverage){
        return coverageService.updateCoverage(coverageId, coverage);
    }
    @DeleteMapping(value = "/delete/{coverageId}")
    public void deleteCoverage(@PathVariable Long coverageId){
        coverageService.deleteCoverageById(coverageId);
    }
    @PostMapping(value = "/new")
    public Coverage addNewCoverage(Coverage coverage){
        return coverageService.addNewCoverage(coverage);
    }
}
