package CoinJam;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Coins {
	
	private int N;
	private int J;

	private long jamCoin[];
	private long nonTrivialDivisor[][];
	
	public Coins(int N, int J){
		this.N = N;
		this.J = J;
		jamCoin = new long[J];
		nonTrivialDivisor = new long[J][9];
		workHorse();
	}
	
	public void workHorse(){
		if(N < 2)
			System.out.println("Length of Jam Coin too Small!");

		String coin = "";
		for(int x = 0; x < N-2; x++)
			coin += 0;

		for(int x = 0; x < J; x++){
			long i;
			do{
				i = Long.valueOf(coin, 2);
				i++;
				coin = Long.toBinaryString(i);
				
				while(coin.length() != N-2)
					coin = "0" + coin;

				if(coin.length() > N - 2){
					System.out.println("Not Possible");
					break;
				}

			}while(!checkIfJamCoinIsNotPrime(Long.parseLong("1" + coin + "1")));
			
			jamCoin[x] = Long.parseLong("1" + coin + "1");
			
			getDivisors(x, jamCoin[x]);
		}
	}

	private void getDivisors(int iteration, long coin){

		for (int base : new int[]{ 2, 3, 4, 5, 6, 7, 8, 9, 10}){
			long prime = 2;
			while(!(Long.valueOf(coin + "", base) % prime == 0)){
				prime = getNextPrime(prime);
				System.out.println(prime + Long.valueOf(coin + "", base));
			}
			nonTrivialDivisor[iteration][base - 2] = (int) prime;

		}
	}

	private boolean isPrime(long n) {
	    if (n%2==0)
	    	return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	private long getNextPrime(long number){
		do{
			number++;
		}while(!isPrime(number));

		return number;
	}

	private boolean checkIfJamCoinIsNotPrime(long coin){
		for (int base : new int[]{ 2, 3, 4, 5 , 6, 7, 8, 9, 10}){
			long i = Long.valueOf(Long.toString(coin), base);
			
			if(isPrime(i))
				return false;
		}
		return true;
	}
	
	public long[] getJamCoin(){
		return jamCoin;
	}
	
	public long[][] getNonTrivialDivisor(){
		return nonTrivialDivisor;
	}
	
	public String toString(){
		String jamCoinProperties = "";
		for(int x = 0; x < J; x++){
			jamCoinProperties += jamCoin[x] +"";
		
			for(int y = 0; y < 9; y++){
				jamCoinProperties += " " + nonTrivialDivisor[x][y];
			}
			jamCoinProperties += "\n";
		}
		return jamCoinProperties;
	}
	
	public static void main(String... Args){
		try{
			Scanner input = new Scanner(new File("src/CoinJam/input.txt"));
			PrintWriter output = new PrintWriter("src/CoinJam/output.txt");
			
			int numberOfCases = Integer.parseInt(input.nextLine());

			for(int c = 1; c <= numberOfCases; c++){

				
				String inputVariables[] = input.nextLine().split(" ");
				int N = Integer.parseInt(inputVariables[0]);
				int J = Integer.parseInt(inputVariables[1]);
				
				Coins jamCoin = new Coins(N, J);
				output.println("Case #" + c + ": ");
				output.printf(jamCoin.toString());

			}
			
			input.close();
			output.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
