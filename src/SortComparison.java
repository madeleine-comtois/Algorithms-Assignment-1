// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Madeleine Comtois - 17301720
 * @version 24/02/19
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
	}

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

	}

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
		double[] temp = new double[a.length];
		for (int size = 1; size < a.length; size = size*2)
			for(int low = 0; low < a.length-size; low += size*2)
				merge(a, temp, low, low+size-1, Math.min(low+(size*2)-1, a.length-1));
		return a;

	}

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
		double[] temp = new double[a.length];
		sort(a, temp, 0, a.length - 1);
		return a;

	}

	static void sort(double[] a, double[] temp, int low, int high) {
		if (high <= low)
			return;
		int mid = low + (high - low) / 2;
		sort(a, temp, low, mid);
		sort(a, temp, mid+1, high);
		merge(a, temp, low, mid, high);

	}

	static void merge(double[] a, double[] temp, int low, int mid, int high) {
		for (int k = low; k <= high; k++)
			temp[k] = a[k];
		
		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid)
				a[k] = temp[j++];
			else if (j > high)
				a[k] = temp[i++];
			else if (temp[j] < temp[i])
				a[k] = temp[j++];
			else
				a[k] = temp[i++];
				
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

	}

	public static void main(String[] args) {
		double[] array3 = { 1.4, 4.23, 2.0, 7.3, 5.23, 3.2832, 2.0, 6.9, 9.1, 10.0, 32.1 };
		double[] array1 = { -1.4, 4.23, -2.0, 7.3, -5.23, -3.2832, 2.0, 6.9, -9.1, 10.0, 32.1 };
		mergeSortIterative(array1);
		for (double i : array1) {
			System.out.println(i);
		}
		
	}
 
}// end class
