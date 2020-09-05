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

    public int remove(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if((arr[mid] == target) && (arr[mid]-1 < target)) {
            // 19<20, high = target-i
        } else if ((arr[mid] == target) && (arr[mid]+1 < target)) {
            // 19< 20, high = target+i
        }

        return 0;

    }

    public static void main(String[] args) {

        TwoSum sorter = new TwoSum();
        int[] arr = {7, 5, 3, 3, 2, 1, 4, 6, 12, 17};
        int sum = 6;

        sorter.sort(arr);

        System.out.print("Array: [");
        for (int i=0; i< arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1] + "]");


        int check = 0;
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] != arr[j]) {
                    if (arr[i] + arr[j] == sum) {
                        System.out.print("Possible Sum: ");
                        System.out.println("[" + i + ", " + j + "]");
                        check = 1;
                        break;
                    }
                }
            }
        }

        if(check == 0) {
            System.out.println("-1");
        }
    }
}
