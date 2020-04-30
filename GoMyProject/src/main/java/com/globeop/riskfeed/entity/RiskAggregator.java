package com.globeop.riskfeed.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//@JsonIgnoreProperties({"clientOnboardSet", "modified_date"})
//@JsonIgnoreProperties({"clientOnboardSet"})
@Entity
@Table(name="RiskAggregator")
public class RiskAggregator implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RiskAggregatorId")
	private int id;
	
	@Column(name="RiskAggregatorName")
	private String RiskAggregatorName;
	
	@Column(name="RiskAggregatorContact")
	private String RiskAggregatorContact;
	
	@Column(name="Modified_date")
	private Date Modified_date;
		
	
	@JsonManagedReference	
	@OneToMany(targetEntity = ClientOnboardTable.class, cascade = CascadeType.ALL, mappedBy="riskAggregator") 	
    private Set<ClientOnboardTable> clientOnboardSet;
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(targetEntity = BillTable.class, cascade = CascadeType.ALL, mappedBy="riskAggregator") 	
    private Set<BillTable> billSet;

	public RiskAggregator() {		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRiskAggregatorName() {
		return RiskAggregatorName;
	}

	public void setRiskAggregatorName(String riskAggregatorName) {
		RiskAggregatorName = riskAggregatorName;
	}

	public String getRiskAggregatorContact() {
		return RiskAggregatorContact;
	}

	public void setRiskAggregatorContact(String riskAggregatorContact) {
		RiskAggregatorContact = riskAggregatorContact;
	}

	
	public Date getModified_date() {
		return Modified_date;
	}


	public void setModified_date(Date modified_date) {
		Modified_date = modified_date;
	}


	public Set<ClientOnboardTable> getClientOnboardSet() {
		return clientOnboardSet;
	}

	public void setClientOnboardSet(Set<ClientOnboardTable> clientOnboardSet) {
		this.clientOnboardSet = clientOnboardSet;
	}
	
	public void addClientOnboard(ClientOnboardTable theClientOnboardTable) {
		if(clientOnboardSet==null) {
			clientOnboardSet = new HashSet<ClientOnboardTable>();
		}
		theClientOnboardTable.setRiskAggregator(this);
		this.clientOnboardSet.add(theClientOnboardTable);
    }
	
	public void addBill(BillTable theBillTable) {
		if(theBillTable==null) {
			billSet = new HashSet<BillTable>();
		}
		theBillTable.setRiskAggregator(this);
		this.billSet.add(theBillTable);
    }


	@Override
	public String toString() {
		return "RiskAggregator [id=" + id + ", RiskAggregatorName=" + RiskAggregatorName + ", RiskAggregatorContact="
				+ RiskAggregatorContact + ", Modified_date=" + Modified_date + "]";
	}


	/*
	 * @Override public String toString() { return "RiskAggregator [id=" + id +
	 * ", RiskAggregatorName=" + RiskAggregatorName + ", RiskAggregatorContact=" +
	 * RiskAggregatorContact + ", Modified_date=" + Modified_date +
	 * ", clientOnboardSet=" + clientOnboardSet + "]"; }
	 */	
	
	
}
