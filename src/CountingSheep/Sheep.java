package CountingSheep;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sheep {
	private boolean Number[] = new boolean[10];
	private int N;	
	private int finalNumber;
	
	public Sheep(int N){
		this.N = N;
		workHorse();
	}
	
	public void workHorse(){
		boolean isZero = false; 
		
		if(N == 0)
			isZero = true;
		
		int sheepCounting = 0;
		int c = 1;
		
		while(!areAllTrue(Number) && !isZero){
			sheepCounting = N * c;
			c++;

			if(sheepCounting == 0){
				finalNumber = 0;
				isZero = true;
			}
			
			checkNumber(sheepCounting);
		}
		finalNumber = sheepCounting;
	}
	
	public void checkNumber(int sheepCurrentNumber){
		do{
			Number[sheepCurrentNumber % 10] = true;
			sheepCurrentNumber /= 10;
		}while(0 < sheepCurrentNumber);
	}
	
	public boolean areAllTrue(boolean[] array)
	{
	    for(boolean b : array)
	    	if(!b)
	    		return false;
	    return true;
	}

	public int getFinalNumber(){
		return finalNumber;
	}
	
	public static void main(String... Args){
		try{
			Scanner input = new Scanner(new File("src/CountingSheep/input.txt"));
			PrintWriter output = new PrintWriter("src/CountingSheep/output.txt");
			
			int numberOfCases = input.nextInt();
			
			for(int c = 1; c <= numberOfCases; c++){
				Sheep sheep = new Sheep(input.nextInt());
				
				output.print("Case #" + c + ": ");
				output.println(sheep.getFinalNumber() == 0 ? "INSOMNIA" : sheep.getFinalNumber());

			}
			
			input.close();
			output.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
