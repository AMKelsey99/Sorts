/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.Arrays;

/**
 *
 * @author alana
 */
public class mergeSort {
     /**
     * This is an implementation of the merge sort algorithm.
     * It takes an array that has 2 sort sub-arrays as its contents.
     * The algorithm divides itself and merges the two arrays back together
     * sorted by comparing the elements of the 2 temp arrays.
     * Its run-time is O(n*log(n)). This is better than selection+insertion sort
     * @param arr the array of two sorted sub-arrays
     * @param len the last index in arr
     */
    public static void mergeSort(int[] arr, int len) {
        if (len < 2) {
            return;
        }
        int mid = len/2;
        int[] left = new int[mid], right = new int[len-mid];
        
        left = Arrays.copyOfRange(arr, 0, mid);
        right = Arrays.copyOfRange(arr, mid, len);
        mergeSort(left,mid);
        mergeSort(right,len-mid);
        
        merge(arr, left, right);
    }
    
    /**
     * 
     * @param arr the array to be sorted
     * @param left left sub-array
     * @param right right sub-array
     */
    public static void merge(int[] arr, int[] left, int[] right){
        int i = 0, ii = 0, mid =arr.length/2, beg = 0;
        while (i<mid && ii<arr.length-mid) { //while next is not null
            if(left[i] <= right[ii]) { //if the left array <= right
                arr[beg] = left[i]; //array's next element comes from left
                i++; //increase left index
            } else {
                arr[beg] = right[ii]; //else, array's next element = right
                ii++; //increase right index
            }
            beg++; //increase the main array's index
        }
}
}
