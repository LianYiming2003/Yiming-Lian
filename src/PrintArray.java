///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           zylab12.11
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

public class PrintArray{
    public static void print(int[][] list){
    	int sum = 0;
        //TODO: Print out list with sum at the end of each row
    	for (int i = 0; i < list.length; ++i) {
    		for (int j = 0; j < list[i].length; ++j) {
    			System.out.print(list[i][j] + " ");
    			sum += list[i][j];
    		}
    		System.out.println(sum);
    		sum = 0;
    	}
    }
}
