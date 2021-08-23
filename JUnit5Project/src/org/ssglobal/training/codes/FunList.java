package org.ssglobal.training.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FunList {
	private BufferedReader bufferedReader;
	private Word word; // injectables

	public FunList(String filename) {
		Path path = Paths.get(filename);
		
		try {
			this.bufferedReader = Files.newBufferedReader(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public long countWords() {
		return this.bufferedReader.lines().map((str)->{
			   return str.split(" ") ;
		}).count();
	}
	
	public boolean enableDisplay() {
		if(this.bufferedReader.lines().toArray(String[]::new).length > 0) {
			showLines();
			return true;
		}
		return false;
	}
	
	public void showLines() {
	   this.bufferedReader.lines().forEach((line)->{
			System.out.println(line);
		});
	}
	
	public List<String> getContentList(){
		return this.bufferedReader.lines().collect(Collectors.toList());
	}
	
	public String[] getContentArray() {
		// return this.bufferedReader.lines().toArray(String[]::new);
		return (String[]) this.bufferedReader.lines().toArray();
	}

}

class Word{
	
}
