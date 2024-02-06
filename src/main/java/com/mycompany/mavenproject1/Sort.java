/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

/**
 *
 * @author alana
 */
public class Sort {
    
    @Benchmark @BenchmarkMode(Mode.SingleShotTime) @OutputTimeUnit(TimeUnit.SECONDS)
    public static void insertionSort() {
        int[] insertionArray = new int[1000];
        Random random = new Random();
        System.out.println("Examples of each sort. \n");
        String insertion = "Array before insertion sort:";
        for (int i = 0; i < 1000; i++) {
            insertionArray[i] = random.nextInt(1000);
            insertion += " " + insertionArray[i];
        }
        System.out.println(insertion);
        insertionSort.insertionSort(insertionArray);
    }
    
    @Benchmark @BenchmarkMode(Mode.SingleShotTime) @OutputTimeUnit(TimeUnit.SECONDS)
    public static void insertionSortAlmostSorted() {
        int[] insertionArray = new int[1000];
        Random random = new Random();
        String insertion = "Array before insertion sort, first 500 elements pre-sorted:";
        for (int i = 0; i < 500; i++) {
            insertionArray[i] = i;
            insertion += " " + insertionArray[i];
        }
        for (int i = 500; i < 1000; i++) {
            insertionArray[i] = random.nextInt(1000);
            insertion += " " + insertionArray[i];
        }
        System.out.println(insertion);
        insertionSort.insertionSort(insertionArray);
    }
    
    @Benchmark @BenchmarkMode(Mode.SingleShotTime) @OutputTimeUnit(TimeUnit.SECONDS)
    public static void selectionSort() {
        int[] selectionArray = new int[1000];
        Random random = new Random();
        String selection = "\nArray before selection sort:";
        for (int i = 0; i < 1000; i++) {
            selectionArray[i] = random.nextInt(1000);
            selection += " " + selectionArray[i];
        }
        System.out.println(selection);
        selectionSort.selectionSort(selectionArray);
    }
    
    @Benchmark @BenchmarkMode(Mode.SingleShotTime) @OutputTimeUnit(TimeUnit.SECONDS)
    public static void selectionSortAlmostSorted() {
        int[] selectionArray = new int[1000];
        Random random = new Random();
        String selection = "Array before selection sort, first 500 elements pre-sorted:";
        for (int i = 0; i < 500; i++) {
            selectionArray[i] = i;
            selection += " " + selectionArray[i];
        }
        for (int i = 500; i < 1000; i++) {
            selectionArray[i] = random.nextInt(1000);
            selection += " " + selectionArray[i];
        }
        System.out.println(selection);
        selectionSort.selectionSort(selectionArray);
    }
    
    @Benchmark @BenchmarkMode(Mode.SingleShotTime) @OutputTimeUnit(TimeUnit.SECONDS)
    public static void mergeSort() {
        String merge = "\nArray before merge sort:";
        int[] mergeArray = new int[1000];
        
        for (int i = 0; i < 500; i++) {
            mergeArray[i] = i;
            merge += " " + mergeArray[i];
        }
        for (int i = 500; i < 1000; i++) {
            mergeArray[i] = i;
            merge += " " + mergeArray[i];
        }

        System.out.println(merge);
        mergeSort.mergeSort(mergeArray,mergeArray.length);
        String out = "Merge sort:";
        for (int i = 0; i<mergeArray.length; i++) {
        out += " " + mergeArray[i];
        }
        System.out.println(out);
    }
    
    @Benchmark @BenchmarkMode(Mode.SingleShotTime) @OutputTimeUnit(TimeUnit.SECONDS)
    public static void quickSort() {
        int[] quickArray = new int[1000];
        Random random = new Random();
        String quick = "\nArray before quick sort:";
        for (int i = 0; i < 1000; i++) {
            quickArray[i] = random.nextInt(1000);
            quick += " " + quickArray[i];
        }
        System.out.println(quick);
        quickSort.quickSort(quickArray, 0, quickArray.length-1);
        String out = "Quick sort:";
        for (int i = 0; i<quickArray.length; i++) {
        out += " " + quickArray[i];
        }
        System.out.println(out);
    }
    
    @Benchmark @BenchmarkMode(Mode.SingleShotTime) @OutputTimeUnit(TimeUnit.SECONDS)
    public static void quickSortAlmostSorted() {
        int[] quickArray = new int[1000];
        Random random = new Random();
        String quick = "Array before quick sort, first 500 elements pre-sorted:";
        for (int i = 0; i < 500; i++) {
            quickArray[i] = i;
            quick += " " + quickArray[i];
        }
        for (int i = 500; i < 1000; i++) {
            quickArray[i] = random.nextInt(1000);
            quick += " " + quickArray[i];
        }
        System.out.println(quick);
        quickSort.quickSort(quickArray, 0, quickArray.length-1);
        String out = "Quick sort:";
        for (int i = 0; i<quickArray.length; i++) {
        out += " " + quickArray[i];
        }
        System.out.println(out);
    }
    
    public static void main(String[] args) throws RunnerException {
        insertionSort();
        insertionSortAlmostSorted();
        selectionSort();
        selectionSortAlmostSorted();
        mergeSort();
        quickSort();
        quickSortAlmostSorted();
        Options opt = new OptionsBuilder()
                        .measurementTime(TimeValue.seconds(3))
                        .measurementIterations(1)
                        .shouldFailOnError(true)
                        .shouldDoGC(true)
                        .threads(1)
                        .forks(1)
                        .build();
        new Runner(opt).run();
    }
       
}
