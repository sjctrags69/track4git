package org.fujitsu.training.codes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SqrtFile {

	public void squareRoot(BigDecimal bigVal) {
		
		DecimalFormat df = new DecimalFormat("###,##0.0");
		df.setRoundingMode(RoundingMode.CEILING);
		MathContext mc = new MathContext(10);
		BigDecimal newVal = bigVal.sqrt(mc);
		String newBigVal = df.format(bigVal);
		String newVal2 = df.format(newVal);
		System.out.format("square root of value of %s = %s \n", newBigVal, newVal2);
		
		SqrtFile sf = new SqrtFile();
		sf.write(newVal2, newBigVal);
	}
	
	public void write(String a, String b) {

		File file = new File("./src/org/fujitsu/training/codes/number.data");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);	
			dos.writeUTF(a);
			dos.flush();
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.format("The square root of %s wrote to the file \"number.data\" \n", a);
		System.out.println("---------------------------------------------------------------------------------");
		
		SqrtFile sf = new SqrtFile();
		sf.read(b);
	}
	
	public void read(String b) {
		
		File file = new File("./src/org/fujitsu/training/codes/number.data");
		try {
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			String a = dis.readUTF();
			System.out.format("The value read from the file \"number.data\": %s \n", a);
			System.out.format("A square number of %s = %s \n", a, b);
			dis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
