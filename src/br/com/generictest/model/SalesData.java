package br.com.generictest.model;

import java.util.List;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public class SalesData {

	private List<Itens> itens;
	private String salesId;
	private SalesmanData salesmanData;
	
	public List<Itens> getItens() {
		return itens;
	}
	public void setItens(List<Itens> itens) {
		this.itens = itens;
	}
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public SalesmanData getSalesmanData() {
		return salesmanData;
	}
	public void setSalesmanData(SalesmanData salesmanData) {
		this.salesmanData = salesmanData;
	}
}
