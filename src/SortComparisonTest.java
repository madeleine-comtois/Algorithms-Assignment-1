import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Madeleine Comtois - 17301720
 *  @version 18/02/19
 */
//-------------------------------------------------------------------------
/*
 * Algorithm performance comparison (in nanoseconds)
 * 
 * 						  |	  Insert	   |	Quick	    |	Merge Recursive		|	Merge Iterative		|	Selection
 * -------------------------------------------------------------------------------------------------------------------------
 * 10 random			  |	  568,725	   |	564,149	    |	   511,100			|		 512,196		|    521,484
 * -------------------------------------------------------------------------------------------------------------------------
 * 100 random			  |	  594,102	   |	613,735	    |	   604,467			|		 581,033		|	 636,907
 * -------------------------------------------------------------------------------------------------------------------------
 * 1000 random			  |	  7,070,203	   |	1,155,212   |      1,960,575		|		 1,325,978		|    62,49,041
 * -------------------------------------------------------------------------------------------------------------------------
 * 1000 few unique		  |	  6,304,647	   |	1,349,897   |      1,953,115		|		 1,159,838		|    6,339,811
 * -------------------------------------------------------------------------------------------------------------------------
 * 1000 nearly ordered    |	  2,315,395	   |	1,026,250   |	   2,076,630		|		 1,253,803		|    28,020,856
 * -------------------------------------------------------------------------------------------------------------------------
 * 1000 reversed order	  |	  9,850,023	   |	837,542	    |	   1,780,378	    |		 1,537,876		|    7,313,378
 * -------------------------------------------------------------------------------------------------------------------------
 * 1000 sorted			  |	  697,016 	   |	1,125,040   |	   1,608,163		|		 1,198,690		|    6,665,466
 * -------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 
*/

@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] array = new double[0];
    	assertNull("Check that insertionSort returns null on an empty array", SortComparison.insertionSort(array));
    	assertNull("Check that quickSort returns null on an empty array", SortComparison.quickSort(array));
    	assertNull("Check that mergeSortRecursive returns null on an empty array", SortComparison.mergeSortRecursive(array));
    	assertNull("Check that mergeSortIterative returns null on an empty array", SortComparison.mergeSortIterative(array));
    	assertNull("Check that selectionSort returns null on an empty array", SortComparison.selectionSort(array));
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.
    
    /**
     * Check that the methods work for an array with a single element
     */
    @Test
    public void testOneElement()
    {
    	double[] array = {1.3};
    	double[] expectedArray = {1.3};
    	
    	SortComparison.insertionSort(array);
    	assertArrayEquals("Check that one element remains the same for insertionSort", array, expectedArray, 0);
    	
    	SortComparison.quickSort(array);
    	assertArrayEquals("Check that one element remains the same for quickSort", array, expectedArray, 0);
    	
    	SortComparison.mergeSortRecursive(array);
    	assertArrayEquals("Check that one element remains the same for mergeSortRecursive", array, expectedArray, 0);
    	
    	SortComparison.mergeSortIterative(array);
    	assertArrayEquals("Check that one element remains the same for mergeSortIterative", array, expectedArray, 0);
    	
    	SortComparison.selectionSort(array);
    	assertArrayEquals("Check that one element remains the same for selectionSort", array, expectedArray, 0);
    	
    }
    /**
     * Check that the methods work for arrays with random double values
     */
    @Test
    public void testMultipleElements() {
    	double[] array1 = { 1.4, 4.23, 2.0, 7.3, 5.23, 3.2832, 2.0, 6.9, 9.1, 10.0, 32.1 };
    	double[] expectedArray = {1.4, 2.0, 2.0, 3.2832, 4.23, 5.23, 6.9, 7.3, 9.1, 10.0, 32.1};
    	
    	SortComparison.insertionSort(array1);
    	assertArrayEquals("Check that one element remains the same for insertionSort", array1, expectedArray, 0);
    	
    	double[] array2 = { 1.4, 4.23, 2.0, 7.3, 5.23, 3.2832, 2.0, 6.9, 9.1, 10.0, 32.1 };
    	SortComparison.quickSort(array2);
    	assertArrayEquals("Check that one element remains the same for quickSort", array2, expectedArray, 0);
    	
    	double[] array3 = { 1.4, 4.23, 2.0, 7.3, 5.23, 3.2832, 2.0, 6.9, 9.1, 10.0, 32.1 };
    	SortComparison.mergeSortRecursive(array3);
    	assertArrayEquals("Check that one element remains the same for mergeSortRecursive", array3, expectedArray, 0);
    	
    	double[] array4 = { 1.4, 4.23, 2.0, 7.3, 5.23, 3.2832, 2.0, 6.9, 9.1, 10.0, 32.1 };
    	SortComparison.mergeSortIterative(array4);
    	assertArrayEquals("Check that one element remains the same for mergeSortIterative", array4, expectedArray, 0);
    	
    	double[] array5 = { 1.4, 4.23, 2.0, 7.3, 5.23, 3.2832, 2.0, 6.9, 9.1, 10.0, 32.1 };
    	SortComparison.selectionSort(array5);
    	assertArrayEquals("Check that one element remains the same for selectionSort", array5, expectedArray, 0);
    }
    
    /**
     * Check that the methods work for arrays with negative values
     */
    @Test
    public void testNegativeElements() {
    	double[] array1 = { -1.4, 4.23, -2.0, 7.3, -5.23, -3.2832, 2.0, 6.9, -9.1, 10.0, 32.1 };
    	double[] expectedArray = {-9.1, -5.23, -3.2832, -2.0, -1.4, 2.0, 4.23, 6.9, 7.3, 10.0, 32.1};
    	
    	SortComparison.insertionSort(array1);
    	assertArrayEquals("Check that one element remains the same for insertionSort", array1, expectedArray, 0);
    	
    	double[] array2 = { -1.4, 4.23, -2.0, 7.3, -5.23, -3.2832, 2.0, 6.9, -9.1, 10.0, 32.1 };
    	SortComparison.quickSort(array2);
    	assertArrayEquals("Check that one element remains the same for quickSort", array2, expectedArray, 0);
    	
    	double[] array3 = { -1.4, 4.23, -2.0, 7.3, -5.23, -3.2832, 2.0, 6.9, -9.1, 10.0, 32.1 };
    	SortComparison.mergeSortRecursive(array3);
    	assertArrayEquals("Check that one element remains the same for mergeSortRecursive", array3, expectedArray, 0);
    	
    	double[] array4 = { -1.4, 4.23, -2.0, 7.3, -5.23, -3.2832, 2.0, 6.9, -9.1, 10.0, 32.1 };
    	SortComparison.mergeSortIterative(array4);
    	assertArrayEquals("Check that one element remains the same for mergeSortIterative", array4, expectedArray, 0);
    	
    	double[] array5 = { -1.4, 4.23, -2.0, 7.3, -5.23, -3.2832, 2.0, 6.9, -9.1, 10.0, 32.1 };
    	SortComparison.selectionSort(array5);
    	assertArrayEquals("Check that one element remains the same for selectionSort", array5, expectedArray, 0);
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws FileNotFoundException 
     *
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("numbersNearlyOrdered1000.txt"));
        double[] numbers10 = new double[1000];
        int i = 0;
        while (in.hasNextDouble()) {
        	numbers10[i++] = in.nextDouble();
        }
       
        final long startTime = System.nanoTime();
        SortComparison.quickSort(numbers10);
        final long duration = System.nanoTime() - startTime;
        
        for (double num : numbers10)
        	System.out.println(num);
        
       
        System.out.println("Time in nanoseconds: " + duration);
    } 

}
