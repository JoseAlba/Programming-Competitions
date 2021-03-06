package Rank_and_File;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class rank {
	int array[];
	String input = "";
	String result = "";
	String permutations[];
	
	public rank(String input){
		this.input = input;
		workHorse();
	}
	
	public void workHorse(){

		if(input.length() == 1){
			setResult(input);
		}
		
		else{
			int counter = 0;
			while(result.length()  != input.length() - 1 ){
				if(input.charAt(counter) < input.charAt(counter + 1))
					result =  result + input.charAt(counter);
				
				else
					result = input.charAt(counter) + result;
				counter++;
			}

			setResult(result);
		}
	}
	
	private void setResult(String input2) {
		result = input2;
	}
	
	private String getResult(){
		return result;
	}

	public String toString(){
		return "1b";
	}
	
	public static void main(String... Args){
		try{
			Scanner input = new Scanner(new File("src/Rank_and_File/input.txt"));
			PrintWriter output = new PrintWriter("src/Rank_and_File/output.txt");
			
			int numberOfCases = Integer.parseInt(input.nextLine());
			
			for(int c = 1; c <= numberOfCases; c++){
				rank eachOne = new rank(input.nextLine());
				
				output.print("Case #" + c + ": ");
				output.println(eachOne.getResult());
			}
			
			input.close();
			output.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
