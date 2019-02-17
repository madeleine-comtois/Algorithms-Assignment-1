

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Madeleine Comtois - 17301720
 *  @version 16/02/19
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){

        int i, j;
        double index;
        
        for(i = 1; i < a.length; i++) {
        	index = a[i];
        	j = i -1;
        	while ( (j >= 0) && (a[j] > index)) {
        		a[j +1] = a[j];
        		j = j -1;
        		
        	}
        	a[j +1] = index;
        }
        return a;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	
		quickSortRecursive(a, 0, a.length -1);
		return a;

    }//end quicksort
    
    static void quickSortRecursive(double[] a, int low, int high) {
    	if (high <= low)
    		return;
    	
    	int lt = low, gt = high;
    	double temp = a[low];
    	int i = low;
    	
    	while (i < gt) {
    		if (a[i] < temp)
    			swap(a, lt++, i++);
    		else if (a[i] > temp)
    			swap(a, i, gt--);
    		else
    			i++;
    	}
    	
    	quickSortRecursive(a, low, lt -1);
    	quickSortRecursive(a, gt + 1, high);
    	
    	/*
    	int pivot = partition(a, low, high);
    	quickSortRecursive(a, low, pivot - 1);
    	quickSortRecursive(a, pivot + 1, high);
    	*/
    	
    }
    
    public static int partition(double[] a, int left, int right) {
		double pivot = a[(left + right) / 2];
		while (left <= right) {
			while (a[left] < pivot)
				left++;
			while (a[right] > pivot)
				right--;
			if (left < right) {
				swap(a, left, right);
				left++;
				right++;
			}
		}
		return left;
	}
    
    public static void swap(double[] a, int left, int right) {
		double temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
		 sort(a);
		 return a;
	
    }//end mergesortIterative
    
    static void sort(double[] a) {
    	double[] temp = new double[a.length];
    	for (int width = 1; width < a.length; width = 2 * width) {
    		for (int low = 0; low < a.length - width; low += width + width) {
    			merge(a, temp, low, low+width-1, Math.min(low + width + width -1, a.length -1));
    		}
    	}
    }
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {

    	double[] temp = new double[a.length];
    	int low = 0;
    	int high = a.length -1;
    	sort(a, temp, low, high);
    	return a;
	
   }//end mergeSortRecursive
    
    static void sort(double[] a, double[] temp, int low, int high) {
    	if (high <= low)
    		return;
    	int mid = low + (high - low) / 2;
    	sort(temp, a, low, mid);
    	sort(temp, a, mid + 1, high);
    	merge(a, temp, low, mid, high);
    	
    }
    
    static void merge(double[] a, double[] temp, int low, int mid, int high) {
    	int i = low, j = mid -1;
    	for(int k = low; k <= high; k++) {
    		if (i > mid)
    			temp[k] = a[j++];
    		else if (j > high)
    			temp[k] = a[i++];
    		else if (a[j] < a[i])
    			temp[k] = a[j++];
    		else
    			temp[k] = a[i++];
    	}
    }
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
         
         for (int i = 0; i < a.length - 1; i++) {
        	 int minimumIndex = i;
        	 for (int j = i+1; j < a.length; j++) {
        		 if (a[j] < a[minimumIndex])
        			 minimumIndex = j;
        		 
        		 double temp = a[minimumIndex];
        		 a[minimumIndex] = a[i];
        		 a[i] = temp;
        	 }
         }
         return a;

    }//end selectionsort

   
    public static void main(String[] args) {

    	double[] array = {1.4, 4.23, 2.0, 7.3, 5.23, 3.2832, 2.0, 6.9, 9.1, 10.0, 32.1};
    	insertionSort(array);
    	for (double i : array)
			System.out.println(i);
    }

 }//end class
