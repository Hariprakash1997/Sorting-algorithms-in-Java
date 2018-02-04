package javaAlgorithms;

public class practise {
	
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	public void generateRandomArray() {
		
		for(int i = 0 ; i < arraySize ; i++) {
			
			theArray[i] = (int)(Math.random()*10) + 10;
			
		}
		
	}
	
	public void printArray() {
		
		for(int i = 0 ; i < arraySize ; i++) {
			
			System.out.println("----------");
			
			System.out.print("| " + i + " |");
			System.out.println(theArray[i] + " |");
			
		}
		
		System.out.println("----------");
		
	}
	
	public int valueAtIndex(int index) {
		
		if(index < arraySize) {
			
			return theArray[index];
			
		}
		
		return 0;
		
	}
	
	public boolean doesArrayContainValue(int searchValue) {
		
		boolean valueInArray = false;
		
		for(int i = 0 ; i < arraySize ; i++) {
			
			if(theArray[i] == searchValue) {
				
				valueInArray = true;
				
			}
			
		}
		return valueInArray;
		
	}
	
	public void deleteIndex(int index) {
		
		if(index < arraySize) {
			
			for(int i = index ; i < (arraySize - 1) ; i++) {
				
				theArray[i] = theArray[i + 1];
				
			}
			
			arraySize--;
			
		}
		
	}
	
	public void insertValue(int value) {
		
		if(arraySize < 50) {
			
			theArray[arraySize] = value;
			
		}
		
		arraySize++;
		
	}
	
	public String linearSearch(int value) {
		
		boolean valueInArray = false;
		String indexWithValue = "";
		
		
		
		for(int i = 0 ; i < arraySize ; i++) {
			
			if(theArray[i] == value) {
				
				valueInArray = true;
				System.out.print(i + " ");
				indexWithValue += i + " ";
				
			}
			
		}
		
		if(!valueInArray) {
			
			System.out.println("None");
			
		}
		
		return indexWithValue;
		
	}
	
	public static void main(String args[]) {
		
		practise p = new practise();
		p.generateRandomArray();
		p.printArray();
		System.out.println(p.valueAtIndex(6));
		System.out.println(p.doesArrayContainValue(17));
		p.deleteIndex(4);
		p.printArray();
		p.insertValue(12);
		p.printArray();
		p.linearSearch(15);
		
	}

}
