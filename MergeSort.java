import java.util.Arrays;


public class MergeSort {
	
	public static void mergeSort(int[] arr, int lo, int hi) {
			if (hi <= lo) { return; }
			int mid = lo + (hi-lo) / 2;
			mergeSort(arr,lo,mid);
			mergeSort(arr,mid+1,hi);
			merge(arr,lo,mid,hi);
		
	}

	public static void merge(int[] arr, int lo, int mid, int hi) {
		
		int[] aux = new int[hi-lo+1];
		int ct = 0;
		// Fill the aux array
		for (int i = lo ; i <= hi ; i++) {
			aux[ct++] = arr[i];
		}
	
		int m = (mid-lo);
		int h = hi-lo;
		int j = 0;
		int k = m;
		
		while (j < m || k < h) {
			if (j >= m) {
				arr[lo+ct] = aux[k];
				k++;
			} else if (k >= h) {
				arr[lo+ct] = aux[j];
				j++;
			} else {
				if (aux[j] < aux[k]) {
					arr[lo+ct] = aux[j];
					j++;
				} else {
					aux[lo+ct] = aux[k];
					k++;
				}
			}
			ct++;
		}
	}
	
}
