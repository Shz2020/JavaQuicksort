package quicksort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Quicksort {
	private static Random random = new java.util.Random();
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> List<T> sort(List<T> list) {
		Object[] array = list.toArray();
		quickSort(array,0,array.length);		
		return (List<T>) Arrays.asList(array); 
	}
	
	
	/**
	 * @param array : Reference to array to sort
	 * @param start : Starting index of sublist (included)
	 * @param end : Ending index of sublist (excluded)
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<? super T>> void quickSort(Object[] array, int start, int end) {
		int pivot=random.nextInt(end-start)+start;
		
		//Shifting pivot to last index
		T elPivot = (T)array[pivot];
		swap(pivot,end-1,array);

		//Rearranging elements
		int i = start;
		int j = end-1; 
		while (i!=j) {
			while (i<j && elPivot.compareTo((T)array[i])>=0)
				i++;
			while (j>i && elPivot.compareTo((T)array[j])<=0)
				j--;
			if(i!=j)
				Quicksort.swap(i, j, array);
		}
		
		// The correct position of the pivot element in the array now is 'i'
		swap(i,end-1,array); 

		if (i-start>1) 
			quickSort(array,start,i);
		if (end-i-1>1)
			quickSort(array,i+1,end);
	}
	
	private static <T> void swap(int a, int b, Object[] array) {
		Object tmp = array[b];
		array[b]=array[a];
		array[a]=tmp;
	}
}
