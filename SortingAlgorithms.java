package Lap4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class SortingAlgorithms {
	// Task 1.1
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int max = i;
			for (int j = i + 1; j < array.length; j++) {
				// tim index phan tu lon nhat
				if (array[j] > array[max])
					max = j;
			}
			// swap
			int tmp = array[max];
			array[max] = array[i];
			array[i] = tmp;
		}
	}

	// Task 1.2
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] < array[j + 1]) {
					// swap
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
	}

	// Task 1.3
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			// lay i len
			int tmp = array[i];
			int j = i - 1;
			// tim vi tri chinh xac de chen i vao
			while (j >= 0 && tmp > array[j]) {
				// dich chuyen cac phan tu len phia truoc
				array[j + 1] = array[j];
				j--;
			}
			// chen i vao vi tri da tim (j)
			array[j + 1] = tmp;
		}
	}

	// Task 2.1
	public static void mergeSort(int[] array) {
		int mid = array.length / 2;
		if (array.length > 1) {
			int[] l = Arrays.copyOfRange(array, 0, mid);
			int[] r = Arrays.copyOfRange(array, mid, array.length);
			mergeSort(l);
			mergeSort(r);
			merge(l, r, array);
		}
	}

	private static void merge(int[] l, int[] r, int[] array) {
		int i = 0, j = 0, k = 0;
		while (i < l.length && j < r.length) {
			if (l[i] >= r[j]) {
				array[k] = l[i];
				i++;
			} else {
				array[k] = r[j];
				j++;
			}
			k++;
		}
		while (i < l.length) {
			array[k] = l[i];
			i++;
			k++;
		}
		while (j < r.length) {
			array[k] = r[j];
			j++;
			k++;
		}
	}

	// Task 2.2
	public static void quickSort(int[] array) {
		quickSortHelp(array, 0, array.length -1);
	}
	public static void quickSortHelp(int[] array, int l, int r) {
		if (l < r) {
		// chon khoa
		int pivot = getPivot_First(array, l, r);
		int partitionIndex = partition(array, l, r, pivot);
		quickSortHelp(array, l, partitionIndex - 1);
		quickSortHelp(array, partitionIndex +1, r);
		}
	}

	private static int partition(int[] array, int l, int r, int pivot) {
		int pivotValue = array[pivot];
		swap(array, pivot, r);
		for (int i = l; i < r; i++) {
			if (array[i] <= pivotValue) {
				swap(array, i, l);
				l++;
			}
		}
		swap(array, l, r);
		return l;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static int getPivot_MedianOfThree(int[] array, int l, int r) {
		int mid = (r-l) / 2;
		if (array[l] > array[mid]) {
			if (array[mid] > array[r]) {
				return mid;
			} else if (array[l] < array[mid]) {
				return r;
			} else {
				return l;
			}
		} else {
			if (array[l] > array[r]) {
				return l;
			} else if (array[l] > array[r]) {
				return r;
			} else {
				return mid;
			}
		}
	}

	private static int getPivot_First(int[]aray, int l, int r) {
		return l;
	}

	private static int getPivot_Last(int[] array,int l, int r) {
		return r;
	}

	private static int getPivot_Random(int[] array, int l, int r) {
		Random random = new Random();
		return random.nextInt(r - l + 1) + l; 
	}

	public static void printArr(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 2, 7, 4, 8, 3 };
//		bubbleSort(arr);
//		selectionSort(arr);
//		mergeSort(arr);
//		insertionSort(arr);
		quickSort(arr);
		printArr(arr);
	}
}
