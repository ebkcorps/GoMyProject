package com.globeop.riskfeed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.globeop.riskfeed.entity.RiskAggregator;

/*@RepositoryRestResource(path ="riskAggregators")*/
public interface RiskAggregatorRepository extends JpaRepository<RiskAggregator, Integer> {
	
	public List<RiskAggregator> findByRiskAggregatorNameStartingWith(String riskAggregatorName);

}
