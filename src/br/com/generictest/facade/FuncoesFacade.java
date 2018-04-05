package br.com.generictest.facade;

import java.io.IOException;

import br.com.generictest.rn.DataAnalysisRN;

public class FuncoesFacade {

	private DataAnalysisRN dataAnalysisRN = new DataAnalysisRN();
	
	public FuncoesFacade() {
		
	}
	
	public void dataAnalysis() {
		try {
			dataAnalysisRN.fileAnalysis();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
