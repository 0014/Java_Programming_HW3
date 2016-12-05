package team_questions.bubble_sort;

//Exercise19.5: BubbleSortTest
//Sorting an array with bubble sort.
import java.security.SecureRandom;
import java.util.Arrays;

public class BubbleSort
{
	// sort array using bubble sort
	public static void bubbleSort(int[] data)              
	{
	   // loop data.length - 1 times to find the greatest number     
	   for (int i = 0; i < data.length - 1; i++)
	   {
	      // loop to swap successive pairs of elements              
	      for (int index = 0; index < data.length - i -1; index++){
	     	 if (data[index] > data[index + 1]){
	     	 
	     	 int temporary = data[index]; // store first in temporary
	     	 data[index] = data[index + 1]; // replace first with second
	          data[index + 1] = temporary; // put temporary in second 
	      }
	      }
	      printPass(data, i + 1); // output pass of algorithm  
	   }                                          
	} // end method bubbleSort                                    
	
	// print a pass of the algorithm
	private static void printPass(int[] data, int pass)
	{
	   System.out.printf("after pass %2d: ", pass);
	
	   // output elements till selected item
	   for (int i = 0; i < data.length - pass; i++)
	      System.out.printf("%d  ", data[i]);
	
	   System.out.printf("%d* ", data[data.length-pass]); // indicate selected item
	
	   // finish outputting array
	   for (int i = data.length - pass + 1; i < data.length; i++)
	      System.out.printf("%d  ", data[i]);
	   System.out.println();
	} 
	
	public static void main(String[] args)
	{
	   SecureRandom generator = new SecureRandom();
	
	   int[] data = new int[10]; // create array
	
	   for (int i = 0; i < data.length; i++) // populate array
	      data[i] = 10 + generator.nextInt(90);
	
	   System.out.printf("Unsorted array:%n%s%n%n", 
	      Arrays.toString(data)); // display array
	   bubbleSort(data); // sort array
	   
	   System.out.println();
	   System.out.printf("Sorted array:%n%s%n%n", 
	      Arrays.toString(data)); // display array
	} 
} // end class BubbleSortTest
