/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author alana
 */
public class selectionSort {
    /**
     * This is an implementation of the selection sort algorithm.
     * Selection sort is only useful for a small number of elements.
     * It must repeatedly scan the whole array for the next-lowest element.
     * Its run-time is O(n^2). This is not efficient.
     * @param arr the array of integers to be sorted 
     */
    public static void selectionSort(int[] arr) {
        int len = arr.length, key = 0, smallest = 0;
        for (int i = 0; i < len-1; i++) { //setting key to never be null; the last element should already be in place at the last swap
            key = i;
            for (int ii = i+1; ii<len; ii++) { //always one ahead of key, loop continues until it has gone through all the elements to find the smallest
                if (arr[ii] < arr[key]) {
                    key = ii; //key now equals the smallest
                }
            }
            smallest = arr[key]; //hold key in a temporary variable
            arr[key] = arr[i]; //swap i with key
            arr[i] = smallest; //shift the smallest/key to i
        }
        String out = "Selection sort:";
        for (int i = 0; i<len; i++) {
        out += " " + arr[i];
        }
        System.out.println(out);
    }
}
