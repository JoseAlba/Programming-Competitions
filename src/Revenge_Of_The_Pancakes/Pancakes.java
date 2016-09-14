package Revenge_Of_The_Pancakes;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pancakes {
	private String symbols;	
	private int pancake_Flips = 0;
	
	public Pancakes(String symbols){
		this.symbols = symbols;
		workHorse();
	}
	
	public void workHorse(){
		if(!(symbols.contains("+") || symbols.contains("-")))
			System.out.println("Improper Input!");
		
		int bottom_Of_Pancake = symbols.length() - 1;
		
		if(bottom_Of_Pancake == -1)
			System.out.println("No Input!");

		char[] symbolsSwitch = symbols.toCharArray();

		for(; bottom_Of_Pancake >= 0; bottom_Of_Pancake--){
			if(numberIsOdd(pancake_Flips)){
				if(symbolsSwitch[bottom_Of_Pancake] == '-')
					symbolsSwitch[bottom_Of_Pancake] = '+';
				else
					symbolsSwitch[bottom_Of_Pancake] = '-';
			}
			
			if(symbolsSwitch[bottom_Of_Pancake] == '-'){
				symbolsSwitch[bottom_Of_Pancake] = '+';
				pancake_Flips++;
			}

		}
		symbols = String.valueOf(symbolsSwitch);
	}
	
	private boolean numberIsOdd(int number){
		return(!(number % 2 == 0));
	}
	

	public int getPancakeFlips(){
		return pancake_Flips;
	}
	
	public static void main(String... Args){
		try{
			Scanner input = new Scanner(new File("src/Revenge_Of_The_Pancakes/input1.txt"));
			PrintWriter output = new PrintWriter("src/Revenge_Of_The_Pancakes/output1.txt");
			
			int numberOfCases = Integer.parseInt(input.nextLine());
			
			for(int c = 1; c <= numberOfCases; c++){
				Pancakes pancake = new Pancakes(input.nextLine());
				
				output.println("Case #" + c + ": " + pancake.getPancakeFlips());

			}
			
			input.close();
			output.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
