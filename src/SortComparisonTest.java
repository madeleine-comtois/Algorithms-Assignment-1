import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

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
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    } 

}
