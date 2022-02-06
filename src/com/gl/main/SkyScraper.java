package com.gl.main;

import java.util.Scanner;
import java.util.Stack;

import com.gl.services.MergeSort;

public class SkyScraper {
	public static void main(String[] args) {
        //Declare a scanner
        Scanner sc = new Scanner(System.in);

        //Input total num of floors
        System.out.println("Enter the total no of floors in the building");
        int noOfFloors = sc.nextInt();

        //Input floor size on day basis
        int[] dayWiseFloorSizes = new int[noOfFloors];
        for (int i = 0; i < noOfFloors; i++) {
            System.out.println("Enter the floor size given on day: " + (i + 1));
            dayWiseFloorSizes[i] = sc.nextInt();
        }


        int[] ascFloorSizesArr = dayWiseFloorSizes.clone();
        var mergeSort = new MergeSort();
        mergeSort.sortArray(ascFloorSizesArr);


        var descFloorSizesStack = new Stack<Integer>();
        for (int i : ascFloorSizesArr) {
            descFloorSizesStack.push(i);
        }


        System.out.println("The order of construction is as follows");
        var tempStack = new Stack<Integer>();

        for (int i = 0; i < noOfFloors; i++) {
            System.out.println("Day: " + (i + 1));
            int floorSizeOfTheDay = dayWiseFloorSizes[i];

            int largestFloorSize = descFloorSizesStack.peek();
            if (floorSizeOfTheDay != largestFloorSize) {
                tempStack.push(floorSizeOfTheDay);
            } else {
                System.out.print(descFloorSizesStack.pop() + " ");
                while (!tempStack.isEmpty() && descFloorSizesStack.peek() == tempStack.peek()) {
                    var poppedItem = descFloorSizesStack.pop();
                    tempStack.pop();
                    System.out.print(poppedItem + " ");
                }
            }
            System.out.println("");
        }

        sc.close();
    }
}
