package org.fujitsu.training.codes;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class CoffeePackage {

	final double PRICE_COFFEE = 5.5; 
	final double PRICE_L = 1.2;
	final double PRICE_M = 1.0;
	final double PRICE_S = 0.60;
	
	public void coffeePack(String data) {
		
		Scanner scan = new Scanner(System.in);
		CoffeePackage cf= new CoffeePackage();
		DecimalFormat df = new DecimalFormat("###,##0.00");
		int newData = Integer.parseInt(data);
		double priceBag = newData * PRICE_COFFEE;
		String newPriceBag = df.format(priceBag);
		
		System.out.format("Number of Bags Ordered: %s - $ %s\n", data, newPriceBag);
		
		int large = 0;
		int medium = 0;
		int small = 0;
		int counter = newData;
		while(counter != 0) {

			if(counter >= 20) {
				counter = counter - 20;
				large++;
			}

			else{
				if(counter < 20 && counter >= 10) {
					counter = counter - 10;
					medium++;
				}
				else {
					if(counter >= 5) {
						counter = counter - 5;
						small++;
					}
					else {
						counter = counter - counter;
						small++;
					}
				}
			}
		
		}

		String pLarge = df.format(large * PRICE_L);
		String pMedium = df.format(medium * PRICE_M);
		String pSmall = df.format(small * PRICE_S);
		System.out.println("Boxed Used:");
		System.out.format(" 		%d Large  - $%s \n", large, pLarge);
		System.out.format(" 		%d Medium - $%s \n", medium, pMedium);
		System.out.format(" 		%d Small  - $%s \n", small, pSmall);
		System.out.print("Your Total Cost is : ");
		System.out.println(cf.compute(priceBag, large, medium, small));
		
		System.out.println("Do you want to add more? [Y/N]");
		String data2 = scan.next();
		
		boolean ctr = false;
		boolean check = data2.equals("Y");
		boolean check2 = data2.equals("y");
		boolean check3 = data2.equals("N");
		boolean check4 = data2.equals("n");
		while(ctr == false) {
			
			if(check == true || check2 == true) {
				ctr = true;
				System.out.println("How many bags would you like?");
				String data3 = scan.next();
				int addMore = Integer.parseInt(data3);
				int another = addMore + newData;
				cf.coffeePack(String.valueOf(another));
				
			}
			else if(check3 == true || check4 == true){
				ctr = true;
				System.out.println("Boxed Used:");
				System.out.format(" 		%d Large  - $%s \n", large, pLarge);
				System.out.format(" 		%d Medium - $%s \n", medium, pMedium);
				System.out.format(" 		%d Small  - $%s \n", small, pSmall);
				System.out.print("Your Total Cost is : ");
				System.out.println(cf.compute(priceBag, large, medium, small));
				
				LocalDate now = LocalDate.now();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("'Date of Order:			'MMMM dd, yyyy");
				DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("'Expected Date of Arrival:	'MMMM dd, yyyy");
				String newNow = now.format(dtf);
				String eta = now.plusWeeks(2).format(dtf2);
				System.out.println(newNow);
				System.out.println(eta);
				System.out.println();
				System.out.println("Thank you for visiting Mang Kardo’s Coffee Outlet! ");
				
			}
			else {
				System.out.println("Input is not valid please try again! ");
				data = scan.next();
			}
		}
		
	}
	
	public String compute(double priceBag, int large, int medium, int small) {
		
		DecimalFormat df = new DecimalFormat("$###,##0.00");
		double pLarge = large * PRICE_L;
		double pMedium = medium * PRICE_M;
		double pSmall = small * PRICE_S;
		double sum = pLarge + pMedium + pSmall + priceBag;
		String sumNew = df.format(sum);
		return sumNew;
	}
	
}
