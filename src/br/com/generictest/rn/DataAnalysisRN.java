package br.com.generictest.rn;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import br.com.generictest.model.CustomerData;
import br.com.generictest.model.Itens;
import br.com.generictest.model.SalesData;
import br.com.generictest.model.SalesmanData;
import br.com.generictest.ws.FileData;

public class DataAnalysisRN {

	private static final String SALESMAN_DATA = "001";
	private static final String CUSTOMER_DATA = "002";
	private static final String SALES_DATA = "003";
	
	private FileData fileData = new FileData();
	
	public DataAnalysisRN() {
		
	}
	
	public void fileAnalysis() throws IOException {
		BufferedReader br = fileData.readFile();
		String temp = null;
		List<SalesmanData> salemanList = new ArrayList<>();
		List<CustomerData> customerList = new ArrayList<>();
		List<SalesData> salesList = new ArrayList<>();
		
		while ((temp = br.readLine()) != null) {
			if(temp.contains(SALESMAN_DATA)) {
				salemanList.add(readSalesman(temp));
			} else if(temp.contains(CUSTOMER_DATA)) {
				customerList.add(readCustomer(temp));
			} else if(temp.contains(SALES_DATA)) {
				salesList.add(readSales(temp, salemanList));
			}
		}
		
		writeData(customerList, salemanList, salesList);
	}
	
	public SalesmanData readSalesman(String temp) {
		String[] argLine = temp.split("ç");
		SalesmanData salesman = new SalesmanData();
		salesman.setCpf(argLine[1]);
		salesman.setName(argLine[2]);
		salesman.setSalary(argLine[3]);
		return salesman;
	}
	
	
	public CustomerData readCustomer(String temp) {
		String[] argLine = temp.split("ç");
		CustomerData customer = new CustomerData();
		customer.setCnpj(argLine[1]);
		customer.setName(argLine[2]);
		customer.setBusinessArea(argLine[3]);
		return customer;
	}
	
	public SalesData readSales(String temp, List<SalesmanData> salemanList) {
		String[] argLine = temp.split("ç");
		SalesData sales = new SalesData();
		List<Itens> itens = new ArrayList<>();
		Itens item = new Itens();
		sales.setSalesId(argLine[1]);
		for(SalesmanData data : salemanList) {
			if(data.getName().equals(argLine[3])) {
				sales.setSalesmanData(data);
			}
		}
		//Pegando os itens
		String[] argIten = argLine[2].split("-");
		item.setId(argIten[1]);
		item.setQtd(argIten[2]);
		item.setPrice(argIten[3]);
		itens.add(item);
		sales.setItens(itens);
		return sales;
	}
	
	public void writeData(List<CustomerData> customer, List<SalesmanData> saleman, List<SalesData> salesList) {
	// Quantidade de clientes no arquivo - Amount of clients in the input file
		
		String customerStr = "Quantidade de clientes: " + customer.size();
		String salesmanStr = "Quantidade de vendedores: " + saleman.size();
		
		mostExpesiveSale(salesList);
	}
	
	public SalesData mostExpesiveSale(List<SalesData> listSales) {
		int price = 0;
		int i = 0;
		Map<String, Integer> object = new HashMap<>(); 
		for(SalesData data : listSales) {
			for(Itens item : data.getItens()) {
				int aux = Integer.parseInt(item.getPrice());
				price += aux;
			}
			object.put(data.getSalesId(), price);
		}
		
		
		
		return null;
	}
}


//Map<String, Integer> concurrentMap = new ConcurrentHashMap<String, Integer>(object);
//String maxKey = concurrentMap.keySet().iterator().next();
//Integer max = object.get(maxKey);
//
//for(String key : concurrentMap.keySet()){
//    Integer currValue = concurrentMap.get(key);
//    if(max >= currValue){
//    	object.values().stream().findAny().of(currValue.toString());
//    }
//}