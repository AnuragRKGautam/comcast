package com.comcast.taxperson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.BreakIterator;
import java.util.Scanner;

import javax.swing.text.html.parser.ParserDelegator;

public class Taxperson {

	public  double itemCost;
	public static double totalCostOfItem;
	
	public static void main(String[] args) throws IOException{
		double inputPrice=0;
		String StrInputPrice;
		String StrInputItemType = null;
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.print("Please provide the price of the item. It should be a number with upto 2 decimal values"+'\n');
		
		 
		 try{
		 StrInputPrice=br.readLine();
		 inputPrice=Double.parseDouble(StrInputPrice);
		 
		 
		 
		 }
		 catch (NumberFormatException | IOException e) {
				
				System.out.println("Value Provided for input price is not a number with upto two decimal. Hence exiting ");
			  System.exit(0);
		
			}
		 try{
			 BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			 System.out.print("Please provide itemtype. It should be lux or nec"+'\n');
			
			 StrInputItemType=br1.readLine().toLowerCase().trim();
		 }
		 catch(StringIndexOutOfBoundsException | IOException e)
		 {
			 System.out.println("Value Provided for input type not a stringnumber with upto two decimal. Hence exiting ");
		 }
		
		double value =totalCost(inputPrice, StrInputItemType);
		BigDecimal b = new BigDecimal(value).setScale(2,BigDecimal.ROUND_HALF_UP);
		value=b.doubleValue();
		System.out.println("Base Price is: "+inputPrice+" and Total Price with Tax is: "+value);
	 
	}

	//This method takes price marked on item and Item Type to calcuate final price based on tax.
	
	public static double totalCost(double price, String itemType)
{
//price calculation for luxury items based on assumption of 9% tax 
	if(itemType.equalsIgnoreCase("lux"))
	{
		totalCostOfItem=(price+(price*0.09));
	}
	//price calculation for necessary items based on assumption of 1% tax 
	else if(itemType.equalsIgnoreCase("nec"))
	{
		totalCostOfItem=(price+(price*0.01));
	}
	//System Exit if user choses tax type other than nec or lux. 
	else
	{
		System.out.println("Item type is not Lux or Nec. hence exiting.");
		System.exit(0);

	}
	return totalCostOfItem;
	
}
}
