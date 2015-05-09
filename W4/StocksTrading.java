package com.itu.assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class StocksTrading {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the stock trading menu!");
		System.out.println("-----------------------------");
		System.out.println("Press 1 to enter a new stock");
		System.out.println("Press 2 to find the LIFO and FIFO price for a stock.");
		System.out.println("Press 3 to quit");
		
		Stack<StockRecord> stockTradingStack = new Stack<StockRecord>();
		Queue<StockRecord> stockTradingQueue = new LinkedList<StockRecord>();

		Scanner scanner = new Scanner(System.in);
		while(true){

			String option = scanner.nextLine();
			System.out.println(option);

			switch(option){
				case "1":  {
	
					System.out.println("Enter stock symbol, no of shares and price :");
					System.out.println("Ex: PNQ 20 13.5");
					String record = scanner.nextLine();
					StringTokenizer stringTokenizer = new StringTokenizer(record);
	
	
					StockRecord stockRecord = new StockRecord((String)stringTokenizer.nextElement(), 
							(String)stringTokenizer.nextElement(), 
							(String)stringTokenizer.nextElement());
					
					stockTradingStack.push(stockRecord);
					stockTradingQueue.offer(stockRecord);

					break;
				}

				case "2":  {
					System.out.println("Enter stock symbol and no. of shares:");
					String record = scanner.nextLine();
					StringTokenizer stringTokenizer = new StringTokenizer(record);
					String[] input = new String[2];
	
					input[0] = (String)stringTokenizer.nextElement();
					input[1] = (String)stringTokenizer.nextElement();
					
					Integer shares = new Integer(input[1]);
					
					StockRecord recStack = stockTradingStack.pop();
					System.out.println("Average price by FIFO:" + new Float(shares.intValue()/recStack.priceRec).toString());
					
					StockRecord recQueue = stockTradingQueue.poll();
					System.out.println("Average price by LIFO:" + new Float(shares.intValue()/recQueue.priceRec).toString());

					break;
	
				}
			
				case "3":  {
					System.out.print("Existing program ..... ");
					scanner.close();
					System.exit(0);
				}
			}
		}
	
	}

	private static class StockRecord{
		private String nameRec;
		private int sharesRec;
		private float priceRec;
		
		StockRecord(String name, String shares, String price){
			nameRec=name;
			
			Integer sharesInt = new Integer(shares);
			sharesRec = sharesInt.intValue();
			
			Float priceFloat = new Float(price);
			priceRec = priceFloat.floatValue();
			
		}
		
		public String getName(){
			return nameRec;
		}
		
		@Override
		public String toString(){
			return "Record: " + " Name-"+nameRec + " shares-"+sharesRec + " price-"+priceRec;
		}
	}
}
