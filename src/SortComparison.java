// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Madeleine Comtois - 17301720
 * @version 18/02/19
 */ 

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {
		if (a.length == 0)
			return null;
		int i, j;
		double index;

		for (i = 1; i < a.length; i++) {
			index = a[i];
			j = i - 1;
			while ((j >= 0) && (a[j] > index)) {
				a[j + 1] = a[j];
				j = j - 1;

			}
			a[j + 1] = index;
		}
		return a;
	}// end insertionsort

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort(double a[]) {
		if (a.length == 0)
			return null;
		quickSortRecursive(a, 0, a.length - 1);
		return a;

	}// end quicksort

	static void quickSortRecursive(double[] a, int low, int high) {
		if (low >= high)
			return;

		double pivot = a[low + (high - low) / 2];

		int i = low, j = high;

		while (i <= j) {
			while (a[i] < pivot)
				i++;
			while (a[j] > pivot)
				j--;

			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}

		if (low < j)
			quickSortRecursive(a, low, j);
		if (high > i)
			quickSortRecursive(a, i, high);

	}

	public static void swap(double[] a, int left, int right) {
		double temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSortIterative(double a[]) {
		if (a.length == 0)
			return null;
		int rght, high;
		int i, j, low;
		double[] temp = new double[a.length];

		for (int k = 1; k < a.length; k *= 2) {
			for (int left = 0; left + k < a.length; left += k * 2) {
				rght = left + k;
				high = rght + k;
				if (high > a.length)
					high = a.length;
				low = left;
				i = left;
				j = rght;
				while (i < rght && j < high) {
					if (a[i] <= a[j])
						temp[low++] = a[i++];
					else
						temp[low++] = a[j++];

				}
				while (i < rght)
					temp[low++] = a[i++];

				while (j < high)
					temp[low++] = a[j++];

				for (low = left; low < high; low++)
					a[low] = temp[low];

			}
		}
		return a;

	}// end mergesortIterative

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */
	static double[] mergeSortRecursive(double a[]) {
		if (a.length == 0)
			return null;
		sort(a, 0, a.length - 1);
		return a;

	}// end mergeSortRecursive

	static void sort(double[] a, int low, int high) {
		if (high <= low)
			return;
		int mid = low + (high - low) / 2;
		sort(a, low, mid);
		sort(a, mid + 1, high);
		merge(a, low, mid, high);

	}

	static void merge(double[] a, int low, int mid, int high) {
		double[] temp = new double[high - low + 1];
		int i = low, j = mid + 1, n = 0;

		while (i <= mid || j <= high) {
			if (i > mid)
				temp[n] = a[j++];
			else if (j > high)
				temp[n] = a[i++];
			else if (a[i] < a[j])
				temp[n] = a[i++];
			else
				temp[n] = a[j++];

			n++;
		}

		for (i = low; i <= high; i++) {
			a[i] = temp[i - low];
		}

	}

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {
		if (a.length == 0)
			return null;

		for (int i = 0; i < a.length - 1; i++) {
			int minimumIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minimumIndex])
					minimumIndex = j;

			}
			double temp = a[minimumIndex];
			a[minimumIndex] = a[i];
			a[i] = temp;
		}
		return a;

	}// end selectionsort

	public static void main(String[] args) {

		double[] array = { 1.4, 4.23, 2.0, 7.3, 5.23, 3.2832, 2.0, 6.9, 9.1, 10.0, 32.1 };
		//double[] array = null;
		insertionSort(array);
		
		for (double i : array)
			System.out.println(i); 
	}

}// end class
