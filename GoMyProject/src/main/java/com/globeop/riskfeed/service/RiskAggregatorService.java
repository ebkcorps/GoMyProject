package com.globeop.riskfeed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globeop.riskfeed.entity.RiskAggregator;
import com.globeop.riskfeed.repository.RiskAggregatorRepository;

import org.springframework.data.domain.Sort;

@Service
public class RiskAggregatorService implements CommonService<RiskAggregator> {

	private RiskAggregatorRepository riskAggregatorRepository;
	
	private Sort sortByRiskAggregatorNameAsc() {
        return new Sort(Sort.Direction.ASC, "riskAggregatorName");
    }
	
	@Autowired
	public RiskAggregatorService(RiskAggregatorRepository riskAggregatorRepository) {		
		this.riskAggregatorRepository = riskAggregatorRepository;
	}

	@Override
	public List<RiskAggregator> findAll() {
		// TODO Auto-generated method stub
		return riskAggregatorRepository.findAll(sortByRiskAggregatorNameAsc());		
	}

	@Override
	public RiskAggregator findById(int theId) {
		Optional<RiskAggregator> result = riskAggregatorRepository.findById(theId);
		RiskAggregator theRiskAggregator=null;
		
		if (result.isPresent()) {
			theRiskAggregator = result.get();
		}
		else {
			throw new RuntimeException("Did not find RiskAggregator id - " + theId);
		}
		return theRiskAggregator;
	}

		
	public boolean checkRiskAggregatorAlreadyExist(String name) {
		List<RiskAggregator> riskAggregators = riskAggregatorRepository.findByRiskAggregatorNameStartingWith(name);
		if(riskAggregators==null) {
			return false;
		}
		for(RiskAggregator riskAggregator : riskAggregators) {
			if(riskAggregator.getRiskAggregatorName().equals(name)) 
				return true;						
		}
		return false;
	}
	
	@Override
	public void save(RiskAggregator theRiskAggregator) {
		riskAggregatorRepository.save(theRiskAggregator);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
