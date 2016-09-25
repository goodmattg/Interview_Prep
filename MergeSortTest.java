import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class MergeSortTest {

//	@Test
//	public void test() {
//		int[] a = {1,4,7};
//		int[] b = {2,5,8};
//		int[] ret = MergeSort.merge(a, b);
//		System.out.println(Arrays.toString(ret));
//		assertEquals(ret[1],2);
//	}
//	
//	@Test
//	public void testIntermed() {
//		int[] a = {1,2,3,4};
//		int[] b = {5,6,7,8,9,10};
//		int[] ret = MergeSort.merge(a, b);
//		System.out.println(Arrays.toString(ret));
//		assertEquals(ret[1],2);
//	}
//	
//	@Test
//	public void testAllSame() {
//		int[] a = {5,5,5};
//		int[] b = {5,5,5};
//		int[] ret = MergeSort.merge(a, b);
//		System.out.println(Arrays.toString(ret));
//		assertEquals(ret[1],5);
//	}

	@Test
	public void mergeSortTest() {
		int[] a = {8,7,6,5,3,2,1};
		MergeSort.mergeSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));

	}
}
