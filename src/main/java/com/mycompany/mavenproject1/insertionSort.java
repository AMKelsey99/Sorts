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

public class insertionSort {
    /**
     * This is an implementation of the insertion sort algorithm.
     * Insertion sort is only useful for a small number of elements.
     * Its run-time is O(n^2). This is not efficient.
     * @param arr the array of integers to be sorted 
     */
    public static void insertionSort(int[] arr) {
        int len = arr.length;
        
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int ii = i;
            while (ii>0 && arr[ii-1]>key) {
                arr[ii] = arr[ii-1]; //shift the smaller number left
                ii--;
            }
            arr[ii] = key; //shift key +1
        }
        String out = "Insertion sort:";
        for (int i = 0; i<len; i++) {
        out += " " + arr[i];
        }
        System.out.println(out);
    }
}
