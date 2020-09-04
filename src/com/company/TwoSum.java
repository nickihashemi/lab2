package com.company;

public class TwoSum {

    //algorithm
    //1. user inputs an array
    //2. selection sort
    //2. sorted with binary search
    //3. try out different sums


    //selection sort
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int findSmallest(int[] arr, int start) {
        int smallestIndex = start;
        for (int i=start + 1; i<arr.length; i++) {
            if (arr[i] < arr[smallestIndex]) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, findSmallest(arr, i));
        }
    }


    //sorted with binary search
    public int search(int[] arr, int target) {
        return binsearch(arr, target, 0, arr.length-1);
    }

    public int binsearch (int[] arr, int target, int low, int high) {
        if (low > high) {       //base case
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return binsearch(arr, target, mid+1, high);
        } else {
            return binsearch(arr, target, low, mid-1);
        }
    }

    public static void main(String[] args) {

        TwoSum sorter = new TwoSum();
        int[] arr = {7, 5, 3, 2, 1, 4, 6, 12, 17};
        sorter.sort(arr);
        for (int i=0; i< arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1]);

        System.out.println("Index of target: " + sorter.search(arr, 6));

        for (int i=0; i< arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1]);


    }
}
