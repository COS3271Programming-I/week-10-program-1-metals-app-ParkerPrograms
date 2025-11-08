package Week10;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Metals_App {
	static Scanner userinput = new Scanner(System.in);

	static double convertToFahrenheit(double temp) {
		//converts the Celsius temp to Fahrenheit
		double answer = temp;
		answer = (9.0 / 5) * answer + 32;
		answer = Math.rint(answer);
		return answer;
	}
	
	public static void main(String args[]) {
		String name;
		double density;
		double melt;
		double boil;
		double hardness;
		//create a list to hold all the data
		List<Object> table = new ArrayList<>();
		String choice = "y";
		int number_of_metals = 0;
		while (!(choice.charAt(0) == 'n')) {
			//get the data from the user
			System.out.println("Enter the name of a metal: ");
			name = userinput.nextLine();
			System.out.println("Enter the density of the metal (in g/cm^3): ");
			density = userinput.nextDouble();
			userinput.nextLine();
			System.out.println("Enter the melting point of the metal in degrees Celsius at standard pressure: ");
			melt = userinput.nextDouble();
			userinput.nextLine();
			System.out.println("Enter the boiling point of the metal in degrees Celsius at standard pressure: ");
			boil = userinput.nextDouble();
			userinput.nextLine();
			System.out.println("Enter the hardness of the metal (this is a number from 0 to 10): ");
			hardness = userinput.nextDouble();
			userinput.nextLine();
			
			//add the values to the list
			table.add(name);
			table.add(Double.toString(density));
			table.add(Double.toString(convertToFahrenheit(melt)));
			table.add(Double.toString(convertToFahrenheit(boil)));
			table.add(Double.toString(hardness));
			
			System.out.println("Would you like to enter information for another metal? (y or n): ");
			choice = userinput.nextLine();
			number_of_metals++;
		}
		//display the data in a table
		System.out.println("Name                 Density (g/cm^3)     Melting Point (°F)   Boiling Point (°F)   Hardness");
		System.out.println("--------------------------------------------------------------------------------------------");
		int i, j;
		for (i=0; i<number_of_metals*5; i+=5) {
			for (j=0; j<5; j++) {
				System.out.format("%-21s", table.get(i+j));
			}
			System.out.println();
		}
		
	}
}
