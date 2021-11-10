package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="flights")
//@NamedQueries({
//	@NamedQuery(name="byRoute", query="from Flight where sources=:src and destiny=:dst"),
//	@NamedQuery(name="byCarrier", query="from Flight where carrier:=car")
//})
public class Flight {
	
	@Id
	private int code;
	@Column(length=20)
	private String source;
	@Column(length=20)
	private String destiny;
	@Column(length=20)
	private String carrier;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	@Override
	public String toString() {
		return "Flight [code=" + code + ", source=" + source + ", destiny=" + destiny + ", carrier=" + carrier + "]";
	}
	
	

}
