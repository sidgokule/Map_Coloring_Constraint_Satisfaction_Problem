package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 /**
  * 
  * @author Siddhant
  *
  */
public class Main {

	/**
	 * @param args
	 */
	   static int n ;
	   static int [][] map = new int[n][n];
		
	public static void main(String[] args) {
		
		List<String> colors = new ArrayList<>();
		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Yellow");
		System.out.println("Enter the number of regions (n) and press ENTER:");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = getTypeOfInput(map,n);
				
		//Uncomment if you wish to see the neighbor-region mapping matrix
//		PrintMap display = new PrintMap();
//		System.out.println("This is the mapping of regions: ");
//		display.printMap(map);

		getChoiceOfAlgorithm(map, n, colors);
		
		
	}
	/**
	 * 
	 * @param map
	 * @param n
	 * @return
	 */
	public static int[][] getTypeOfInput(int[][] map,int n) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Do you want to enter the input or generate a random input. Please insert your choice:\n1. Provide Inputs for map \n2. Randomly generate inputs for me \nPlease type 1 or 2 and press ENTER");
		int inputChoice = in.nextInt();
		switch (inputChoice) {
		case 1:
			UserInput userInput = new UserInput();
			map= userInput.getUserInput(n);
			break;
		case 2:
			RandomInput randomIput = new RandomInput();
			map = randomIput.getRandomInput(n);
			break;
		default:
			System.out.println("Enter valid input!!");
			getTypeOfInput(map,n);
			break;
		}
		return map;
	}
	
	public static void getChoiceOfAlgorithm(int[][]map, int n, List<String>colors)
	{
		System.out.println("\n\n");
		System.out.println("Enter choice of algorithm to implement:\n1.MRV\n2.Min-Conflicts\n3.Run both(for peformance comparison)\nPlease type 1,2 or 3 and press ENTER");
		@SuppressWarnings("resource")
		Scanner in1 = new Scanner(System.in);
		int choice = in1.nextInt();

		switch (choice) {
		case 1:
			MRVSolutionClass mrv = new MRVSolutionClass();
			long MRVstartTime = System.nanoTime();
			mrv.CSP_Using_MRV(map, n, colors);
			long MRVEndTime = System.nanoTime();
			long MRVTimeTaken = (MRVEndTime - MRVstartTime)/1000000;
			System.out.println("Time taken to color a map of "+n+" regions using MRV is "+MRVTimeTaken+" milliseconds");
			System.out.println("\nPress 1 and ENTER to rerun the program and any other number and ENTER to exit");
			Scanner in2= new Scanner(System.in);
			int continueExecution  = in2.nextInt();
			if(continueExecution==1)
				 main(null);
			break;
		case 2:
			MinConflictsSolutionClass minConflicts = new MinConflictsSolutionClass();
			long MinConflictsStartTime = System.nanoTime();
			minConflicts.CSP_Using_MinConflicts(map, colors, n);
			long MinConflictsEndTime = System.nanoTime();
			long MinConflictsTimeTaken = (MinConflictsEndTime - MinConflictsStartTime)/1000000;
			System.out.println("Time taken to color a map of "+n+" regions using MinConflicts is "+MinConflictsTimeTaken+" milliseconds");
			System.out.println("\nPress 1 and ENTER to rerun the program and any other number and ENTER to exit");
			 in2= new Scanner(System.in);
			 continueExecution = in2.nextInt();
			 if(continueExecution==1)
				 main(null);
			break;
		case 3:
			MRVSolutionClass mrv1 = new MRVSolutionClass();
			MinConflictsSolutionClass minConflicts1 = new MinConflictsSolutionClass();
			long MRVstartTime1 = System.nanoTime();
			mrv1.CSP_Using_MRV(map, n, colors);
			long MRVEndTime1 = System.nanoTime();
			long MRVTimeTaken1 = (MRVEndTime1 - MRVstartTime1)/1000000;
			long MinConflictsStartTime1 = System.nanoTime();
			minConflicts1.CSP_Using_MinConflicts(map, colors, n);
			long MinConflictsEndTime1 = System.nanoTime();
			long MinConflictsTimeTaken1 = (MinConflictsEndTime1 - MinConflictsStartTime1)/1000000;
			System.out.println("Time taken to color a map of "+n+" regions using MRV is "+MRVTimeTaken1+" milliseconds");
			System.out.println("Time taken to color a map of "+n+" regions using MinConflicts is "+MinConflictsTimeTaken1+" milliseconds");
			System.out.println("\nPress 1 and ENTER to rerun the program and any other number and ENTER to exit");
			 in2= new Scanner(System.in);
			 continueExecution = in2.nextInt();
			 if(continueExecution==1)
				 main(null);
			break;
		default:
			System.out.println("Enter valid choice (Either 1 or 2 or 3)!");
			getChoiceOfAlgorithm(map, n, colors);
			break;
		}
	}
}
