package org.ssglobal.training.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;
import java.util.stream.Collectors;

public class FunList {
	private BufferedReader bufferedReader;
	private Word word; // injectables
	
	// Step 1: Create a logger
	private static Logger logger  = Logger.getLogger(FunList.class.getName());
	
		{
		// Step 2: Creating another handler
				// Step 3: Format the message
			logger.setLevel(Level.ALL);
			try {
				FileHandler fileHandler = new FileHandler("./src/log/funlist.log", true);
				fileHandler.setEncoding("UTF-8");
				fileHandler.setLevel(Level.INFO);
					
				SimpleFormatter formatter = new SimpleFormatter();
				fileHandler.setFormatter(formatter);
					
				logger.addHandler(fileHandler);
					
			} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
	
	public FunList() {
		// Step 1b: Set the logging level
	}

	public FunList(String filename) {
	
		Path path = Paths.get(filename);
		
		try {
			this.bufferedReader = Files.newBufferedReader(path);
		} catch (IOException e) {
			// Step 1c: Apply logging
			logger.severe("Error message: " + e.getMessage());
		}
	}
	
	public long countWords() {
		logger.info("execute countWords");
		long temp = this.bufferedReader.lines().map((str)->{
			   return str.split(" ");}).count();
		logger.info("exit without countWords");
		return temp ;
		
	}
	
	@SuppressWarnings("deprecation")
	public boolean enableDisplay() {
		logger.info("execute enableDisplay");
		
		logger.warning("custom Date is deprecated");
		Date xmas = new Date(121, 11, 25);
		
		try {
			if(this.bufferedReader.lines().toArray(String[]::new).length > 0) {
				showLines();
				logger.info("exit without errors enableDisplay");
				return true;
			}
			
		}catch(Exception e) {
			// Step 1c: Apply logging
			logger.severe("Error message: {0} " + e.getMessage());
		}
		
		logger.info("exit with errors enableDisplay");
		return false;
	}
	
	public void showLines() {
	   logger.info("execute showLines");
	   this.bufferedReader.lines().forEach((line)->{
			System.out.println(line);
		});
	   logger.info("exit without errors showLines");
	}
	
	public List<String> getContentList(){
		logger.info("execute showLines");
		List<String> temp = this.bufferedReader.lines().collect(Collectors.toList());
		logger.info("exit without errors showLines");
		return temp;
	}
	
	public String[] getContentArray() {
		// return this.bufferedReader.lines().toArray(String[]::new);
		return (String[]) this.bufferedReader.lines().toArray();
	}
	
	public String processStr(String str1, String str2) {
		return String.join(" ", str1, str2);
	}

}

class Word{
	
}
