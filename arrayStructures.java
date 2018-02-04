package javaAlgorithms;

public class arrayStructures {
	
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	public void generateRandomArray() {
		
		for(int i = 0 ; i < arraySize ; i++) {
			
			theArray[i] = (int)(Math.random() * 10) + 10;
			
		}
		
	}
	
	public void printArray() {
		
		for(int i = 0 ; i < arraySize ; i++) {
			
			System.out.println("----------");
			
			System.out.print("| " + i + " |");
			System.out.println(theArray[i] + " |");
						
		}
		
	}
	
	public int valueAtIndex(int index) {
		
		if(index < arraySize) {
			return theArray[index];
		}
		
		return 0;
		
	}
	
	public boolean doesThisArrayConatinThisValue(int searchValue) {
		
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
			
			arraySize++;
			
		}
		
	}
	
	public String linearSearch(int value) {
		
		boolean valueInArray = false;
		String indexWithValue = "";
		
		System.out.print("The value " + value +" is found in the following indices : ");
		
		for(int i = 0 ; i < arraySize ; i++) {
			
			if(theArray[i] == value) {
				
				valueInArray = true;
				System.out.print(i + " ");
				indexWithValue += i +" ";
				
			}
						
		}
		
		if(!valueInArray) {
			
			indexWithValue = "None";
			System.out.println(indexWithValue);
			
		}
		return indexWithValue;
		
	}
	
	public static void main(String[] args) {
		
		arrayStructures array = new arrayStructures();
		array.generateRandomArray();
		array.printArray();
		System.out.println("----------");
		System.out.println(array.valueAtIndex(5)); 
		System.out.println(array.doesThisArrayConatinThisValue(18));
		array.deleteIndex(5);
		array.printArray();
		array.insertValue(55);
		array.printArray();
		System.out.println("----------");
		array.linearSearch(17);
		
	}

}
