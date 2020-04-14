package com.globeop.riskfeed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globeop.riskfeed.entity.ClientTable;
import com.globeop.riskfeed.entity.RiskAggregator;
import com.globeop.riskfeed.repository.RiskAggregatorRepository;

@Service
public class RiskAggregatorService implements CommonService<RiskAggregator> {

	private RiskAggregatorRepository riskAggregatorRepository;
	
	
	@Autowired
	public RiskAggregatorService(RiskAggregatorRepository riskAggregatorRepository) {		
		this.riskAggregatorRepository = riskAggregatorRepository;
	}

	@Override
	public List<RiskAggregator> findAll() {
		// TODO Auto-generated method stub
		return riskAggregatorRepository.findAll();
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

	@Override
	public void save(RiskAggregator theRiskAggregator) {
		riskAggregatorRepository.save(theRiskAggregator);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
