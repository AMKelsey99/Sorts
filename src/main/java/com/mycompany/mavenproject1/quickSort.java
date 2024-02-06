/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

 /**
     * This is an implementation of the quick sort algorithm.
     * The array is divided and sorted recursively after it
     * splits the list around the pivot.
     * The array does not have to be 2 sorted sub-arrays like merge sort.
     * Its runtime is O(n*log(n)). This is better than selection+insertion sort
     * @param arr the array to be sorted
     * @param beg the beginning index of arr
     * @param end the last index in arr
     */
public class quickSort {
     public static void quickSort(int[] arr, int beg, int end) {
        if (beg>=end || arr.length == 0 || arr == null) {
            return;
        }
        //set pivot to middle element
        int mid = (beg+(end-beg)/2), pivot = arr[mid]; 
        int i = beg, ii = end, hold;
        //move left list until the i element isn't < pivot
        while (arr[i] < pivot) {
            i++;
            //System.out.println("less" + arr[i] + " " + pivot + " " + arr[i+1]);
        }
        //move right list until the ii element isn't > pivot
        while (arr[ii] > pivot) {
            ii--;
            //System.out.println("more" + arr[ii] + " " + pivot + " " + arr[ii-1]);
        }
        //if i <= ii but arr[i] > pivot
        if (i <= ii) { //swap if ii >= i
            hold = arr[i];
            arr[i] = arr[ii];
            arr[ii] = hold;
            i++;
            ii--;
        }
        //recurse until beg = ii
        if (beg < ii) {
            quickSort(arr,beg,ii);
        }
        //recurse until i = end
        if (i < end) {
            quickSort(arr,i,end);
        }
        //result is the split list being merged sorted
    }
}
