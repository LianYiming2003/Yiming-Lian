///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           zylab12.10
// Course:          CS200, FIRST term, 2021
//
// Author:          Yiming Lian
// Email:           ylian7@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// 
// 
// 
// 
//  
//         
// 
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Scanner;

public class SeatingChart {

	/** The main method should prompt the user to input two numbers
	 * corresponding to the row and column of their seat choice. This choice 
	 * is then compared to the initial seating chart and updated if the seat
	 * is available. Then user is then informed of the result (whether the 
	 * seat is successfully reserved or already taken).
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		char[][] seating = {{' ', 'x', 'x', ' ', ' '}, 
				{' ', ' ', 'x', 'x', ' '}, 
				{'x', ' ', 'x', ' ', ' '}, 
				{' ', 'x', 'x', 'x', ' '}, 
				{'x', 'x', 'x', 'x', 'x'}};
		int userRow = 0;
		int userColumn = 0;

		//Print seating chart.
		System.out.println("Welcome to seat selector.\n");
		printChart(seating);

		//Prompt user for inputs.
		System.out.println("Please select a row (1-5): ");
		userRow = scnr.nextInt();

		System.out.println("Please select a column (1-5): ");
		userColumn = scnr.nextInt();
		
		if (seating[userRow - 1][userColumn - 1] == 'x') {
			System.out.println("Seat " + userRow + "," + userColumn +  " is already taken.");
		}
		else {
			seating[userRow - 1][userColumn - 1] = 'x';
			System.out.println("Seat " + userRow + "," + userColumn +  " is now reserved.");
		}
		
      //-----------------------------------------------------------------------
		//TODO: Check user's inputs against seating chart, update seating chart 
		//if possible, and inform user of result. All other code should remain 
		//the same.
      //-----------------------------------------------------------------------

		//Print updated seating chart.
		printChart(seating);

		scnr.close();
	}

	/**
	 * This method prints out the elements within the given seating chart.
	 * Additional numbers are printed to format the specific 5x5 array that
	 * is created in the main method.
	 * 
	 * @param chartInput (the seating chart which has already been created)
	 */
	public static void printChart(char[][] chartInput) {
		System.out.println("   1  2  3  4  5");
		for (int i = 0; i < chartInput.length; i++) {
			System.out.print(i + 1 + " ");
			for (int j = 0; j < chartInput[0].length; j++) { 
				System.out.print("[" + chartInput[i][j] + "]");
			}
			System.out.print("\n");
		}
	}
}