package com.globeop.riskfeed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globeop.riskfeed.entity.ClientOnboardTable;
import com.globeop.riskfeed.entity.ClientTable;

import com.globeop.riskfeed.entity.RiskAggregator;

public interface ClientOnboardRepository extends JpaRepository<ClientOnboardTable, Integer> {
	
	//public List<ClientOnboardTable> findByClientAndRisk
	
	public List<ClientOnboardTable> findByClientAndRiskAggregator(ClientTable theClientTable, RiskAggregator theAggregator);
}
