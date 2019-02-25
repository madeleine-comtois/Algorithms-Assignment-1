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
 * @version 24/02/19
 */
//-------------------------------------------------------------------------
/*
 * Algorithm performance comparison (in nanoseconds)
 * 
 * | Insert | Quick | Merge Recursive | Merge Iterative | Selection
 * -----------------------------------------------------------------------------
 * -------------------------------------------- 10 random | 568,725 | 564,149 |
 * 511,100 | 512,196 | 521,484
 * -----------------------------------------------------------------------------
 * -------------------------------------------- 100 random | 594,102 | 613,735 |
 * 604,467 | 581,033 | 636,907
 * -----------------------------------------------------------------------------
 * -------------------------------------------- 1000 random | 7,070,203 |
 * 1,155,212 | 1,960,575 | 1,325,978 | 6,249,041
 * -----------------------------------------------------------------------------
 * -------------------------------------------- 1000 few unique | 6,304,647 |
 * 1,349,897 | 1,953,115 | 1,159,838 | 6,339,811
 * -----------------------------------------------------------------------------
 * -------------------------------------------- 1000 nearly ordered | 2,315,395
 * | 1,026,250 | 2,076,630 | 1,253,803 | 28,020,856
 * -----------------------------------------------------------------------------
 * -------------------------------------------- 1000 reversed order | 9,850,023
 * | 837,542 | 1,780,378 | 1,537,876 | 7,313,378
 * -----------------------------------------------------------------------------
 * -------------------------------------------- 1000 sorted | 697,016 |
 * 1,125,040 | 1,608,163 | 1,198,690 | 6,665,466
 * -----------------------------------------------------------------------------
 * --------------------------------------------
 * 
 * Algorithm performance comparison (in milliseconds)
 * 
 * | Insert | Quick | Merge Recursive | Merge Iterative | Selection
 * -----------------------------------------------------------------------------
 * ---------------------------------- 10 random | 0.00 | 0.33 | 0.33 | 0.33 |
 * 0.33
 * -----------------------------------------------------------------------------
 * ---------------------------------- 100 random | 0.00 | 0.33 | 0.00 | 0.00 |
 * 0.00
 * -----------------------------------------------------------------------------
 * ---------------------------------- 1000 random | 4.33 | 0.00 | 0.67 | 0.67 |
 * 3.00
 * -----------------------------------------------------------------------------
 * ---------------------------------- 1000 few unique | 0.33 | 0.00 | 0.00 |
 * 0.67 | 0.33
 * -----------------------------------------------------------------------------
 * ---------------------------------- 1000 nearly ordered | 0.33 | 0.33 | 0.33 |
 * 0.00 | 1.00
 * -----------------------------------------------------------------------------
 * ---------------------------------- 1000 reversed order | 0.33 | 0.00 | 0.00 |
 * 0.00 | 1.00
 * -----------------------------------------------------------------------------
 * ---------------------------------- 1000 sorted | 0.33 | 0.00 | 0.00 | 0.33 |
 * 0.67
 * -----------------------------------------------------------------------------
 * ----------------------------------
 * 
 * 
 * 
 * A. Which of the sorting algorithms does the order of input have an impact on?
 * Why? Insertion sort
 * 
 * B. Which algorithm has the biggest difference between the best and worst
 * performance, based on the type of input, for the input of size 1000? Why?
 *
 * C. Which algorithm has the best/worst scalability, i.e., the difference in
 * performance time based on the input size? Please consider only input files
 * with random order for this answer.
 * 
 * The insertion sort algorithm has the worst scalability, with a leap from
 * 594,102 nanoseconds to sort a 100 element array to 7,070,203 nanoseconds to
 * sort a 1000 element array. The quick sort algorithm has the best scalability,
 * with a leap from 613,735 nanoseconds to sort a 100 element array and
 * 1,155,212 nanoseconds to sort a 1000 element array
 * 
 * D. Did you observe any difference between iterative and recursive
 * implementations of merge sort? Merge sort performs roughly the same for
 * random 10 elements, but as the arrays get longer and more complex the merge
 * iterative algorithm works faster than the recursive one.
 * 
 * E. Which algorithm is the fastest for each of the 7 input files? 10 random:
 * merge sort recursive 100 random: merge sort iterative 1000 random: quick sort
 * 1000 few unique: merge sort iterative 1000 nearly ordered: quick sort 1000
 * reversed order: quick sort 1000 sorted: insertion sort
 * 
 * 
 * 
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

	public static long calculateTime(Scanner in, String fileName, int numberSize) throws FileNotFoundException {
		double[] numbers = new double[numberSize];
		getValues(in, numbers, fileName);
		final long startTime = System.nanoTime();
		SortComparison.mergeSortRecursive(numbers);
		long duration = System.nanoTime() - startTime;
		System.out.println("Duration in nanoseconds: " + duration);
		duration *= 1000000;
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
