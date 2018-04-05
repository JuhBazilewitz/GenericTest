package br.com.generictest.ws;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileData {

	private static final String fileRead = System.getProperty("user.home") + "\\Data\\in\\flat_file.dat";
	private static final String fileWrite = System.getProperty("user.home") + "\\Data\\out\\sales_file.done.dat";
	
	public FileData() {
		
	}
	
	public BufferedReader readFile() {
		try {
			FileReader file = new FileReader(new File(fileRead));
			BufferedReader br = new BufferedReader(file);
			
			return br;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void writeFile() {
		
	}
}
