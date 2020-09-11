package com.company;

/**
 * finds two indexes that add up to a target sum
 */

public class TwoSum {

    //algorithm
    //1. user inputs an array
    //2. selection sort
    //3. try out different sums

    int check = 0;          // used in twoSum function

    /**
     * Selection Sort
     * This is where swapping occurs and orders the elements from least to greatest
     * @param num
     * @param i
     * @param j
     */
    void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }


    /**
     * Returns the smallest index which will get passed into swap function
     * @param num
     * @param start
     * @return
     */
    int findSmallest(int[] num, int start) {
        int smallestIndex = start;
        for (int i=start + 1; i<num.length; i++) {
            if (num[i] < num[smallestIndex]) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }


    /**
     * Main calls this function to sort the unsorted int array
     * this then calls the swap function to do so
     *      this passes these parameters to do the comparisons
     * @param num
     */
    void sort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            swap(num, i, findSmallest(num, i));
        }
    }


    /**
     * Finds the two sums that make up the target value
     * Checks whether or not the two elements are not equal to each other first
     * If it can't find a match, it returns -1
     * @param num
     * @param sum
     * @return
     */
    public int[] twoSum(int[] num, int sum) {
        for (int i=0; i<num.length-1; i++) {
            for (int j=i+1; j<num.length; j++) {
                if (num[i] != num[j]) {
                    if (num[i] + num[j] == sum) {
                        System.out.print("Possible Sum: ");
                        System.out.println("[" + i + ", " + j + "]");
                        check = 1;      //if sum is found
                        break;
                    }
                }
            }
        }

        if(check == 0) {                //if no sums found
            // System.out.println("Possible Sum: -1 (Not found)");
            int[] wrong = new int[1];
            wrong[0] = -1;
            return wrong;
        }

        return num;

    }


    /**
     * Calls all of the above functions when sort is called
     * prints out the unsorted and sorted int array, sum, and indexes
     * @param args
     */
    public static void main(String[] args) {

        TwoSum sorter = new TwoSum();
        //int[] num = {7, 5, 3, 3, 2, 1, 4, 6, 12, 17};
        int[] num = {100, 20, 40, 50, 50, 12, 4, 9};
        System.out.print("Unsorted Array: [");
        for (int i=0; i< num.length-1; i++) {
            System.out.print(num[i] + ", ");
        }
        System.out.println(num[num.length-1] + "]");


        int sum = 16;             // returns indexes
        // int sum = 100;              // returns -1

        sorter.sort(num);

        System.out.print("Sorted Array: [");
        for (int i=0; i< num.length-1; i++) {
            System.out.print(num[i] + ", ");
        }
        System.out.println(num[num.length-1] + "]");


        System.out.println("Sum: " + sum);

        int[] arr = sorter.twoSum(num, sum);
        if (sorter.check == 0) {
            for (int k=0; k<arr.length; k++) {
                System.out.println(arr[k]);
            }
        }
    }
}
