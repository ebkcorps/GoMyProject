package com.globeop.riskfeed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globeop.riskfeed.entity.BillTable;
import com.globeop.riskfeed.entity.ClientTable;
import com.globeop.riskfeed.entity.RiskAggregator;

public interface BillRepository extends JpaRepository<BillTable, Integer> {

	public List<BillTable> findByClientAndRiskAggregator(ClientTable theClientTable, RiskAggregator theAggregator);
}
