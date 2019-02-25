import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for SortComparison.java
 *
 * @author Madeleine Comtois - 17301720
 * @version 25/02/19
 */
//-------------------------------------------------------------------------
/* 
 * Algorithm performance comparison (in milliseconds)
 * 
 * 						  |	  Insert   |   Quick   |   Merge Recursive   |   Merge Iterative   |   Selection
 * -------------------------------------------------------------------------------------------------------------
 * 10 random              |   0.2639   |   0.2046  |       0.1836        |        0.1919       |     0.2042
 * -------------------------------------------------------------------------------------------------------------
 * 100 random             |   0.0747   |   0.0472  |       0.0843        |        0.0599       |     0.1270
 * -------------------------------------------------------------------------------------------------------------
 * 1000 random            |   3.7034   |   0.2266  |       0.4713        |        0.3903       |     1.7992
 * -------------------------------------------------------------------------------------------------------------
 * 1000 few unique        |   0.1693   |   0.0710  |       0.1362        |        0.1480       |     0.4674
 * -------------------------------------------------------------------------------------------------------------
 * 1000 nearly ordered    |   0.0344   |   0.0392  |       0.0898        |        0.1232       |     0.4298
 * -------------------------------------------------------------------------------------------------------------
 * 1000 reversed order    |   0.4185   |   0.0211  |       0.0642        |        0.0990       |     0.6952
 * -------------------------------------------------------------------------------------------------------------
 * 1000 sorted            |   0.0033   |   0.0227  |       0.0544        |        0.0986       |     0.6568
 * -------------------------------------------------------------------------------------------------------------
 * 
 * 
 * 
 * A. Which of the sorting algorithms does the order of input have an impact on? Why? 
 * 
 * 		Insertion sort performs faster the more sorted the elements are, and it is significantly slower 
 * 		if the elements are in reversed order. If an element in insertion sort is less than a previous element,
 * 		it needs to slide over to the left to be put in place. Therefore, in a reversed array every every element
 * 		would have to move, giving a runtime of Theta(n^2), where n = length of the array.
 * 
 * B. Which algorithm has the biggest difference between the best and worst
 *    performance, based on the type of input for the input of size 1000? Why?
 * 		
 * 		Insertion sort has the greatest difference for best and worst time, as it runs for 3.8034 ms in a random
 * 		1000 element array, but it runs 0.0033 ms for a 1000 element array that is already sorted. This is because
 * 		the order of input for insertion sort has a significant effect on the algorithm's performance.
 * 
 * C. Which algorithm has the best/worst scalability, i.e., the difference in
 *    performance time based on the input size? Please consider only input files
 *    with random order for this answer.
 *    
 *		Quicksort has the best scalability since the runtime for each input size is very similar.  It sorts
 *		a 10 element array in 0.0246 ms and a 1000 element array in 0.2266 ms.  Insertion sort
 *		has the worst scalability since there is a large runtime gap between small and large input sizes, as 
 *		it sorts a 10 element array in 0.2639 ms and a 1000 element array in 3.7034 ms.   
 * 
 * D. Did you observe any difference between iterative and recursive
 *    implementations of merge sort? 
 *    
 * 		The Merge sorts perform roughly the same for random 10 elements, but as the arrays 
 * 		get longer and more complex the merge recursive algorithm works faster than the recursive one.
 *    
 * E. Which algorithm is the fastest for each of the 7 input files?
 * 
 * 		10 random: merge recursive
 * 		100 random: quick sort
 * 		1000 random: quick sort
 * 		1000 few unique: quick sort
 * 		1000 nearly ordered: insertion sort
 * 		1000 reversed order: quick sort
 * 		1000 already sorted: insertion sort
 */

@RunWith(JUnit4.class)
public class SortComparisonTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new SortComparison();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty() {
		double[] array = new double[0];
		assertNull("Check that insertionSort returns null on an empty array", SortComparison.insertionSort(array));
		assertNull("Check that quickSort returns null on an empty array", SortComparison.quickSort(array));
		assertNull("Check that mergeSortRecursive returns null on an empty array",
				SortComparison.mergeSortRecursive(array));
		assertNull("Check that mergeSortIterative returns null on an empty array",
				SortComparison.mergeSortIterative(array));
		assertNull("Check that selectionSort returns null on an empty array", SortComparison.selectionSort(array));
	}

	// TODO: add more tests here. Each line of code and each decision in
	// Collinear.java should
	// be executed at least once from at least one test.

	/**
	 * Check that the methods work for an array with a single element
	 */
	@Test
	public void testOneElement() {
		double[] array = { 1.3 };
		double[] expectedArray = { 1.3 };

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
		double[] expectedArray = { 1.4, 2.0, 2.0, 3.2832, 4.23, 5.23, 6.9, 7.3, 9.1, 10.0, 32.1 };

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
		double[] expectedArray = { -9.1, -5.23, -3.2832, -2.0, -1.4, 2.0, 4.23, 6.9, 7.3, 10.0, 32.1 };

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
	 * Main Method. Use this main method to create the experiments needed to answer
	 * the experimental performance questions of this assignment.
	 * 
	 * @throws FileNotFoundException
	 *
	 */
	public static void main(String[] args) throws FileNotFoundException {

		getAverageTime("numbers10.txt", 10);
		getAverageTime("numbers100.txt", 100);
		getAverageTime("numbers1000.txt", 1000);
		getAverageTime("numbers1000Duplicates.txt", 1000);
		getAverageTime("numbersNearlyOrdered1000.txt", 1000);
		getAverageTime("numbersReversed1000.txt", 1000);
		getAverageTime("numbersSorted1000.txt", 1000);

	}

	@SuppressWarnings("resource")
	public static double[] getValues(Scanner in, double[] numbers, String fileName) throws FileNotFoundException {
		in = new Scanner(new File(fileName));
		int i = 0;
		while (in.hasNextDouble()) {
			numbers[i++] = in.nextDouble();
		}
		return numbers;
	}

	public static double calculateTime(Scanner in, String fileName, int numberSize) throws FileNotFoundException {
		double[] numbers = new double[numberSize];
		getValues(in, numbers, fileName);
		final double startTime = System.nanoTime();
		SortComparison.insertionSort(numbers);
		double duration = System.nanoTime() - startTime;
		duration /= 1000000;
		return duration;

	}

	public static void getAverageTime(String file, int fileSize) throws FileNotFoundException {
		Scanner in = null;
		double time1, time2, time3;
		time1 = calculateTime(in, file, fileSize);
		time2 = calculateTime(in, file, fileSize);
		time3 = calculateTime(in, file, fileSize);
		double averageTime = (time1 + time2 + time3) / 3.0;
		System.out.println("File: " + file);
		System.out.println("Time1: " + time1 + "\t\tTime2: " + time2 + "\t\tTime3: " + time3);
		System.out.println("Average time: " + averageTime + "\n");
	}

}
