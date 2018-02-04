package javaAlgorithms;

import java.util.*;

public class sorting {
	
	private static int[] theArray = new int[10];
	private int arraySize = theArray.length;
	
	//generating random values
	
	public void generateRandomArray() {
		
		System.out.println("The unsorted array is : ");
		
		for(int i = 0 ; i < arraySize ; i++) {
					
			theArray[i] = (int)(Math.random() * 100);
			
		}
		
	}
	
	//printing the random values
	
	public void printArray() {
						
		for(int i = 0 ; i < arraySize ; i++) {
			
			System.out.print(theArray[i] + " ");
			
		}
		
		System.out.println();
		
	}
	
	//method to swap values
	
	public void swapValues(int indexOne , int indexTwo) {
		
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo]  =temp;
		
	}
	
	//Insertion sort
	
	public void doInsertionSort() {
		
		System.out.println("The Insertion Sort is : ");
		
		for(int i = 1 ; i < arraySize ; i++) {
			
			int key = theArray[i];
			
			//int j = i - 1;
			//while(j >= 0 && key < theArray[i]){
			//swapValues(theArray[i] , theArray[j]);
			//}
			
			for(int j = i - 1; j >= 0 ; j--) {
				
				if(key < theArray[j]) {
					
					swapValues(theArray[i] , theArray[j]);
					
				}
				
				else {
					
					break;
					
				}
				
			}
			
		}
		
		printArray();
		
	}
	
	//Bubble sort
	
	public void doBubbleSort() {
		
		System.out.println("The Bubble Sort is : ");
		
		for(int i = 0 ; i < arraySize - 1 ; i++) {
			
			for(int j = 0 ; j < arraySize - 1 - i ; j++) {
				
				if(theArray[j] > theArray[j + 1]) {
					
					swapValues(j , j + 1);
					
				}
				
			}
			
		}
		
		printArray();
		
	}
	
	//Selection sort
	
	public void doSelectionSort() {
		
		System.out.println("The selection sort is : ");
		
		for(int i = 0 ; i < arraySize ; i++) {
			
			int minValue = i;
			
			for(int j = i ; j < arraySize ; j++) {
				
				if(theArray[minValue] > theArray[j]) {
					
					minValue = j;
					
				}
				
			}
			
			swapValues(i , minValue);
			
		}
		
		printArray();
		
	}
	
	//Merge Sorting
	
	public  int[] doMergeSort(int[] theArray) {
		
		if(theArray.length <= 1) {
			
			return theArray;
			
		}
		
		int midpoint = theArray.length / 2;
		
		int[] left = new int[midpoint];
		int[] right;
		
		if(theArray.length % 2 == 0) {
			
			right = new int[midpoint];
			
		}else {
			
			right = new int[midpoint + 1];
			
		}
		
		int[] result = new int[theArray.length];
		
		for(int i = 0 ; i < midpoint ; i++) {
			
			left[i] = theArray[i];
			
		}
		
		int x = 0;
		
		for(int j = midpoint ; j < theArray.length ; j++) {
			
			if(x < right.length) {
				
				right[x] = theArray[j];
				x++;
				
			}
			
		}
		
		left = doMergeSort(left);
		right = doMergeSort(right);
		
		result = merge(left , right);
		
		return result;
		
	}
	
	public  int[] merge(int[] left , int[] right)
	{
		
		int lengthResult = left.length + right.length;
		int result[] = new int[lengthResult];
		int indexL = 0;
		int indexR = 0;
		int indexRes = 0;
		
		while(indexL < left.length || indexR < right.length) {
			
			if(indexL < left.length && indexR < right.length) {
				
				if(left[indexL] <= right[indexR]) {
					
					result[indexRes] = left[indexL];
					indexL++;
					indexRes++;
					
				}
				
				else {
					
					result[indexRes] = right[indexR];
					indexR++;
					indexRes++;
					
				}
				
			}
			
			else if (indexL < left.length){
				
				result[indexRes] = left[indexL];
				indexL++;
				indexRes++;
				
			}
			
			else if(indexR < right.length) {
				
				result[indexRes] = right[indexR];
				indexR++;
				indexRes++;
				
			}
			
		}
		
		return result;
		
	}
	
	//Quick Sorting
	
	public void doQuickSort(int[] theArray) {
		
		doQuickSort(theArray , 0 , theArray.length - 1);
		
	}
	
	private void doQuickSort(int[] theArray , int low , int high) {
		
		if(low < high + 1) {
			
			int p = partititon(theArray , low , high);
			doQuickSort(theArray , 0 , p - 1);
			doQuickSort(theArray , p + 1 , high);
			
		}
		
	}

	private int getPivot(int low , int high) {
		
		Random rand = new Random();
		return rand.nextInt((high - low) + 1) + low;
		
	}
	
	private int partititon(int[] theArray, int low, int high) {
		
		swapValues(low , getPivot(low , high));
		int border = low + 1;
		
		for(int i = border ; i <= high ; i++) {
			
			if(theArray[i] < theArray[low]) {
				
				swapValues(i , border++);
				
			}
			
		}
		
		swapValues(low , border - 1);
		return border - 1;
		
	}
	
	public static void main(String args[]) {
		
		sorting s = new sorting();
		s.generateRandomArray();
		s.printArray();
		s.doBubbleSort();
		s.doInsertionSort();
		s.doSelectionSort();
		System.out.println("The merge sorting is : ");
		s.doMergeSort(theArray);
		s.printArray();
		System.out.println("The quick sorting is : ");
		s.doQuickSort(theArray);
		s.printArray();
		
	}

}
