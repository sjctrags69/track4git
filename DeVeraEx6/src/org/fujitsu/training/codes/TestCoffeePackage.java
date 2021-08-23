package org.fujitsu.training.codes;

import java.math.BigDecimal;
import java.util.Scanner;

public class TestCoffeePackage {

	public static void main(String[] args) {
		
		SqrtFile sqrt = new SqrtFile();
		Scanner scan = new Scanner(System.in);
		CoffeePackage cp = new CoffeePackage();
		System.out.println("Welcome to Mang Kardo’s Coffee Outlet! ");
		System.out.println("We sell 2-lb bags of coffee at the price of $5.5 each bag.");
		System.out.println("Would you like to order? [Y/N]");
		String data = scan.next();
		
		boolean ctr = false;
		boolean check = data.equals("Y");
		boolean check2 = data.equals("y");
		boolean check3 = data.equals("N");
		boolean check4 = data.equals("n");
		while(ctr == false) {
			
			if(check == true || check2 == true) {
				ctr = true;
				System.out.println("How many bags would you like?");
				String data2 = scan.next();
				cp.coffeePack(data2);
				
			}
			else if(check3 == true || check4 == true){
				ctr = true;
				System.out.println("Thank you for visiting Mang Kardo’s Coffee Outlet! ");
				
			}
			else {
				System.out.println("Input is not valid please try again! ");
				data = scan.next();
			}
		}

	}

}
