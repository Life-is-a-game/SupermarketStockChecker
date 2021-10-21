/**
 * 
 */
package supermarketStockCheck;

import java.io.*;
import java.util.*;

/**
 * @author NathanClarke
 *
 */
public class CSVStockCheck {

	/**
	 * @param args
	 */
	
	private static Scanner scnr = new Scanner(System.in);
	private static List<Stock> stockList = new ArrayList<Stock>();
	private static String[] colNames = {"ID", "Stock Name", "Initial Stock", "Updated Stock", "Refill Amount"};
	
	public static void main(String[] args) {
		boolean flag = true;
		while(flag) {
			try {
				FileReader fR = new FileReader("src/Audit.csv");
				BufferedReader buff = new BufferedReader(fR);
				
				System.out.println("What do you wish to do?\nInput 1 to check the audit\nInput 2 to update stock\nOr input 3 to quit the program");
				int choice = 0;
				
				try{
					if(scnr.hasNextInt()) {
						choice = scnr.nextInt();
					}
					scnr.nextLine();
					
					switch(choice) {
						default:
							System.out.println("Unfortunately, that choice was invalid. Please input another option");
							break;
						case 1:
							showStock(buff);
							buff.close();
							break;
						case 2:							
							updateStock();
							break;
						case 3:
							flag = false;
							break;
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void showStock(BufferedReader bR) {
		try {
			System.out.println("\n\n");
			String line = "";
			int count = 0;
			String[] arr;
				
			while((line = bR.readLine()) != null) {
				if(!(count == 0)) {
					arr = line.split(",");
					int tempId = 0;
					String tempName = "";
					int initStock = 0;
					int updStock = 0;
					int refillAm = 0;
						
					for(int i = 0; i < arr.length; i++) {
						System.out.println(colNames[i] + ": " + arr[i]);
					}
					tempId = Integer.parseInt(arr[0]);
					tempName = arr[1];
					initStock = Integer.parseInt(arr[2]);
					updStock = Integer.parseInt(arr[3]);
					refillAm = Integer.parseInt(arr[4]);
						
					stockList.add(new Stock(tempId, tempName, initStock, updStock, refillAm));
						
					System.out.println("\n---\n");
				}
				count++;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void updateStock() {
		try {
			FileReader fRead = new FileReader("src/Audit.csv");
			BufferedReader bRead = new BufferedReader(fRead);
			
			showStock(bRead);
			
			System.out.println("Which item do you wish to update the stock of? Please input the ID number.");
			int choice = scnr.nextInt();
			scnr.nextLine();
			
			int counter = 0;
			
			for(Stock st : stockList) {
				if(st.getId() == choice) {
					int tempAm = 0;
					System.out.println("\nPlease enter the new amount of stock");
					
					if(scnr.hasNextInt()) {
						tempAm = scnr.nextInt();
					}
					scnr.nextLine();
					
					st.setUpdatedAm(tempAm);
					int inAm = st.getInitAm();
					st.setRefillAm(inAm - tempAm);
					counter = 1;
				}
			}
			bRead.close();
			
			if(counter == 0) {
				System.out.println("No such stock item exists.");
			}
			else {
				FileWriter fWrite = new FileWriter("src/Audit.csv");
				BufferedWriter bW = new BufferedWriter(fWrite);
				
				String str = String.join(",", colNames);
				bW.write(str);
				for(Stock s : stockList) {
					bW.newLine();
					bW.write(s.getId() + "," + s.getName() + "," + s.getInitAm() + "," + s.getUpdatedAm() + "," + s.getRefillAm());
				}
				bW.close();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
