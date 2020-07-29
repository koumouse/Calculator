package Calculator;
import java.util.*;

public class Calculator {

	private static float memory = 0;
	private static LinkedList<String> history = new LinkedList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		String input = "";
		
		System.out.println("Welcome to Bryan's Calculator! "
				+ "Valid operations include: (+ add), (- subtract), (* multiply), (/ divide), \n(% modulus),"
				+ " (m memory), (r recall from memory), (c clear memory), (h history of operations), (q quit) ");
		
		//Loop through user input until quit is entered
		while(!input.equals("q")) {
			System.out.println("\nEnter operation: ");
			input = sc.next();
			
			if(input.equals("+")) {
				System.out.println("Enter values to be added: ");
				try {
					float a = sc.nextFloat();
					float b = sc.nextFloat();
					float total = add(a, b);
					System.out.println(a + " + " + b + " = " + total);
				} catch (InputMismatchException e) {
						System.out.println("Incorrect input. Please enter a number.");
						sc.next();
				}
			}
			
			else if(input.equals("-")) {
				System.out.println("Enter values to be subtracted: ");
				try {
					float a = sc.nextFloat();
					float b = sc.nextFloat();
					float total = subtract(a, b);
					System.out.println(a + " - " + b + " = " + total);
				} catch (InputMismatchException e) {
					System.out.println("Incorrect input. Please enter a number.");
					sc.next();
				}
			}
			
			else if(input.equals("*")) {
				System.out.println("Enter values to be multiplied: ");
				try {
					float a = sc.nextFloat();
					float b = sc.nextFloat();
					float total = multiply(a, b);
					System.out.println(a + " * " + b + " = " + total);
				} catch (InputMismatchException e) {
					System.out.println("Incorrect input. Please enter a number.");
					sc.next();
				}
			}
			
			else if(input.equals("/")) {
				System.out.println("Enter values to be divided: ");
				try {
					float a = sc.nextFloat();
					float b = sc.nextFloat();
					float total = divide(a, b);
					System.out.println(a + " / " + b + " = " + total);
				} catch (InputMismatchException e) {
					System.out.println("Incorrect input. Please enter a number.");
					sc.next();
				}
			}
			
			else if(input.equals("%")) {
				System.out.println("Enter values to be modded: ");
				try {
					int a = sc.nextInt();
					int b = sc.nextInt();
					int total = mod(a, b);
					System.out.println(a + " % " + b + " = " + total);
				} catch (InputMismatchException e) {
					System.out.println("Incorrect input. Please enter an integer.");
					sc.next();
				}
			}
			
			else if(input.equalsIgnoreCase("m")) {
				System.out.println("Enter value to store to memory: ");
				try {
					float a = sc.nextFloat();
					saveToMemory(a);
				} catch (InputMismatchException e) {
					System.out.println("Incorrect input. Please enter a number.");
					sc.next();
				}
			}
			
			else if(input.equalsIgnoreCase("r")) {
				System.out.println("Value from stored memory: " + recallFromMemory());
			}
			
			else if(input.equalsIgnoreCase("c")) {
				System.out.println("Memory was cleared.");
				clearMemory();
			}
			
			else if(input.equalsIgnoreCase("h")) {
				System.out.println("\nRecent Operations History:");
				operationsHistory();
			}
			
			else if(input.equalsIgnoreCase("q")) {
				break;
			}
			
			else {
				System.out.println("Incorrect operation input. Please try again.");
			}
		}
		
		System.out.println("Thank you for using Bryan's Calculator!");
		sc.close();
	}
	
	
	//Returns the sum of two numbers
	public static float add(float x, float y) {
		float sum = x + y;
		history.add(x + " + " + y + " = " + sum);
		return sum;
	}
	
	//Returns the subtraction of two numbers
	public static float subtract(float x, float y) {
		float sub = x - y;
		history.add(x + " - " + y + " = " + sub);
		return sub;
	}
	
	//Returns the multiplication of two numbers
	public static float multiply(float x, float y) {
		float mult = x * y;
		history.add(x + " * " + y + " = " + mult);
		return mult;
	}
	
	//Returns the quotient of two numbers
	public static float divide(float x, float y) {
		float quo = x / y;
		history.add(x + " / " + y + " = " + quo);
		return quo;
	}
	
	//Return the modulus of two numbers
	public static int mod(int x, int y) {
		int modulus = x % y;
		history.add(x + " % " + y + " = " + modulus);	
		return modulus;
	}
	
	//Saves input to memory
	public static void saveToMemory(float x) {
		history.add(x + " was saved to memory.");
		memory = x;
	}
	
	//Returns saved memory data
	public static float recallFromMemory() {
		history.add(memory + " was recalled from memory.");
		return memory;
	}
	
	//Clears any saved memory data
	public static void clearMemory() {
		history.add("Memory cleared.");
		memory = 0;
	}
	
	//Returns a list of the recent operations executed
	public static void operationsHistory() {
		for (String i : history) {
			System.out.println(i);
		}
	}
	
	//
	public static boolean validateNumbers() {
		return true;
	}
}