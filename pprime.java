package testproject;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class pprime {

	public static void main(String[] args) {
		//0. check if array of primenumbers is empty, if empty, populate with 1.
		//1. find largest square before startnumber
		//2. find all prime numbers before largestsquare
		//3. if startnumber is divisible by all prime numbers, startnumber = prime
		//4. else, if the next startnumber's largestsquare = previouslargestsquare, check if divisible by array
		//5. else, find prime number from last prime number from previous array until next largest square and populate the array accordingly
		
		double startnumber = getUserInputInitial();
		double stopnumber = getUserInputFinal();
		
		LinkedList<Double> primelist = new LinkedList<Double>();
		
		
		double previouslargestsquare = 1;
		int largestsquare = 0;
		int primenumbercounter = 0;
		int counter = 0;
		
		if (primelist.size() == 0) {
			primelist = (LinkedList<Double>) makePrimeNumber(previouslargestsquare,largestSquare(startnumber));
			
		}
		long startTime = System.currentTimeMillis();
		while (startnumber < stopnumber) {
			
			if (largestSquare(startnumber) == previouslargestsquare) {
				if (ifDivisible(primelist, startnumber) == true) {
					System.out.println(startnumber + " is prime");
					primenumbercounter++;
				}
			}
			else {
				
				previouslargestsquare++;
				if (isPrimeNumber(previouslargestsquare) == true) {
					primelist.add(previouslargestsquare);
				} 
				
				if (ifDivisible(primelist, startnumber) == true) {
					System.out.println(startnumber + " is prime");
					primenumbercounter++;
				}
				
			}			
			startnumber++;		
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		
		String unit = " Miliseconds";
		if (elapsedTime > 1000) {
			elapsedTime = elapsedTime/1000;
			unit = " Seconds";
		}
		
		System.out.println("That took " + elapsedTime + unit + " to find " + primenumbercounter + " numbers");
		
	}
	
	public static int largestSquare(double inputnumber) {
		int power = 0;
		int counter = 0;
		
		while (power <= inputnumber) {
			counter++;
			power = (int) Math.pow(counter,2);
		}
		return (int) (counter);
		
	}
	
	public static double getUserInputInitial() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		System.out.println("Where do you want to start?");
		double startnumber = reader.nextDouble(); // Scans the next token of the input as an int.
		//reader.close();
		
		return startnumber;
		
	}
	
	public static double getUserInputFinal() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		System.out.println("Where do you want to stop?");
		double stopnumber = reader.nextDouble();
		reader.close();	
		
		return stopnumber;
		
	}
	
	public static List makePrimeNumber(double startnumber,double stopnumber) {
		LinkedList<Double> arraylist = new LinkedList<Double>();
		
		while (startnumber < stopnumber) {
			int counter = 2;
			int primenumbercounter = 0;
			while (counter < startnumber) {
				if (startnumber % counter != 0) {
					primenumbercounter++;
				}
				else {
					break;
				}
				counter++;
			}
			if (primenumbercounter == (startnumber - 2)) {
				arraylist.add(startnumber);
			}	
			startnumber++;
			
		}
		return arraylist;
	}
	
	public static boolean ifDivisible(LinkedList<Double> primelist, double startnumber) {
		int counter = 0;
		int primenumbercounter = 0;
		
		while (counter < primelist.size()) {
			if ((int) startnumber % primelist.get(counter) != 0) {
				primenumbercounter++;
			} else {
				break;
			}
			counter++;
			
		}
		if (primenumbercounter == primelist.size()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static boolean isPrimeNumber(double input) {
		int counter = 0;
		int primenumbercounter = 0;
		
		while (counter < input) {
			if (input % counter != 0) {
				primenumbercounter++;
			}
			else {
				
			}
			counter++;
		}
		if (primenumbercounter == (input - 1)) {
			return true;	
			
		} else {
			return false;
			
		}
	}

}
