package org.fujitsu.training.codes;

import java.math.BigDecimal;
import java.util.Scanner;

public class TestSqrtFile {
	
	public static void main(String[] args) {
	
		SqrtFile sqrt = new SqrtFile();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number: ");
		String data = scan.next();
		BigDecimal bigVal = new BigDecimal(data);
		sqrt.squareRoot(bigVal);

	}

}
