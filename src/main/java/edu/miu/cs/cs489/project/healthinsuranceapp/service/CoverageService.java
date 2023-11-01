package edu.miu.cs.cs489.project.healthinsuranceapp.service;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Coverage;
import edu.miu.cs.cs489.project.healthinsuranceapp.model.Address;

import java.util.List;

public interface CoverageService {
    public List<Coverage> getAllCoverages();
    public Coverage getCoverageById(Long coverageId);
    public Coverage updateCoverage(Long coverageId, Coverage coverage);
    public void deleteCoverageById(Long coverageId);
    public Coverage addNewCoverage(Coverage coverage);
}
