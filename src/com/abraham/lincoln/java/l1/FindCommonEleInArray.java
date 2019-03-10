package com.abraham.lincoln.java.l1;

import java.util.List;
import java.util.Scanner;

/**
 * Get n arrays and find Common Element in all Arrays.
 * Example:
 * I/p
 * a = [10,500,300,45,67,20,10]
 * b = [504,300,56,24,17,8]
 * c = [13,54,300]
 * 
 * O/p = [300]
 */
public class FindCommonEleInArray {
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> commonEleList = new java.util.LinkedList<>();
		try {
			System.out.println("Enter No of Arrays to be entered:");
			int noOfArrays = scanner.nextInt();
			int noOfElementInArray;
			Integer [][]array = new Integer[noOfArrays][100];
			
			// GET ALL ARRAYS
			for (int i = 0; i < noOfArrays; i++) {
				System.out.print("Enter No of Elements for Array "+(i+1)+":");
				noOfElementInArray = scanner.nextInt();
				for (int j = 0; j < noOfElementInArray; j++) {
					array[i][j] = scanner.nextInt();
				}
				System.out.println("-----------------------------------------");
			}
			// Find common Element  in n-Arrays
			//Integer [][]array = {{10,500,45,67,300,20,10}, {504,300,56,24,17,8},{13,54,300} }; //Test By HardCoded values
			Integer []commonElements =  commonElementsInnArray(array);
			if (commonElements != null && commonElements.length > 0) {
				for (int i = 0; i < commonElements.length && commonElements[i] != null; i++) {
					Integer integer = commonElements[i];
					if(integer != null) {
						commonEleList.add(integer);
					}
				} 
			}
			if(commonEleList.size() > 0) {
				System.out.println("Common Elements are");
				commonEleList.forEach(System.out::println);
			}else {
				System.out.println("There are no Commmon Elements !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			scanner.close();
		}
	}

	/**
	 * 
	 * 
	 * @param array
	 * @return common Elements in given 2 Dimensional array
	 */
	private static Integer[] commonElementsInnArray(Integer[][] array) {
		int priorityArrayIndex = 0;
		Boolean breakFlag = false;
		Integer []commonEleArray = null; // OUTPUT ARRAY
		int commonEleArrayIndex = 0;
		try {
			if(array != null && array.length > 0) {
				commonEleArray = new Integer [array[priorityArrayIndex].length];
				Integer []priorityArray = array[priorityArrayIndex];
				for (int i = 0; i < priorityArray.length; i++) {
					Integer priorityArrayVal = priorityArray[i];
					if (!isArrayHasElement(commonEleArray,priorityArrayVal)) {
						for (int j = 1; j < array.length; j++) {
							breakFlag = isArrayHasElement(array[j], priorityArrayVal);
							if (breakFlag) {
								// Element found in a array check for next array.
								continue;
							} else {
								// No Common element found. Check next elements.
								break;
							}
						}
						if (breakFlag) {
							// Found common element in all array
							commonEleArray[commonEleArrayIndex++] = priorityArrayVal;
						} 
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonEleArray;
	}

	/**
	 * Check whether given @param integerArrays has element @param val 
	 * @param integerArray
	 * @param val
	 * @return
	 */
	private static Boolean isArrayHasElement(Integer[] integerArray, Integer val) {
		Boolean isArrayHasElement = false;
		try {
			if (integerArray != null && integerArray.length > 0 && val != null) {
				for (int i = 0; i < integerArray.length && integerArray[i] != null; i++) {
					Integer arrayNum = integerArray[i];
					if (val.equals(arrayNum)) {
						isArrayHasElement = true;
						break;
					}
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isArrayHasElement;
	}

}
