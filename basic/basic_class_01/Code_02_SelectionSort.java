package basic.basic_class_01;

import java.util.Arrays;

public class Code_02_SelectionSort {

	
	//bubble
	public static void bubbleSort2(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		for(int end = arr.length-1; end > 0; end --){
			for(int i = 0; i < end;i++){
				if (arr[i] > arr[i+1])
					swap(arr, i, i+1);
			}
		}
	}
	
	//mergeSort
	public static void mergeSort2(int[] arr) {
		if (arr == null || arr.length < 2) 
			return;
		process(arr, 0, arr.length - 1);
	}
	
	private static void process(int[] arr, int l, int r) {
		if (l == r)
			return;
		int mid = l + ((r-l) >> 1);
		process(arr, l, mid);
		process(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}
	
	private static void merge(int[] arr, int l, int mid, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = mid +1;
		while (p1 <= mid && p2 <= r) {
//			if (arr[p1] < arr[p2])
//				help[i++] = arr[p1++];
//			else
//				help[i++] = arr[p2++];
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}

		while (p1 <= mid){
			help[i++] = arr[p1++];
		}
		while (p2 <= r){
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}

	}
	//select
	public static void selectSort2(int[] arr){
		if (arr == null || arr.length < 2)
			return;
		for (int i = 0; i < arr.length -1; i++){
			int minIndex = i;
			for(int j = i+1; j < arr.length; j++){
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, minIndex, i);
		}
	}
	
	//insertSort
	public static void insertSort2(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		for(int i = 1; i < arr.length; i++) {
			for (int j = i-1; j >= 0 && arr[j+1] < arr[j]; j-- ){
				swap(arr, j, j+1);
			}
		}
	}
	
	
	
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort2(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		mergeSort2(arr);
		printArray(arr);
	}

}
