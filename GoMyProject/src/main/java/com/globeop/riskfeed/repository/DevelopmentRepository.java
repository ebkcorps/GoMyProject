package com.globeop.riskfeed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.globeop.riskfeed.entity.ClientTable;
import com.globeop.riskfeed.entity.DevelopmentTable;
import com.globeop.riskfeed.entity.RiskAggregator;

public interface DevelopmentRepository extends JpaRepository<DevelopmentTable, Integer> {

	public List<DevelopmentTable> findByClientAndRiskAggregator(ClientTable theClientTable, RiskAggregator theAggregator);
}
