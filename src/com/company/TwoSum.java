package com.company;

public class TwoSum {

    // TODO: twoSum header ok?
    // TODO: user input array? or hardcode sum and array ok?

    //algorithm
    //1. user inputs an array
    //2. selection sort
    //3. try out different sums


    //selection sort
    void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    int findSmallest(int[] num, int start) {
        int smallestIndex = start;
        for (int i=start + 1; i<num.length; i++) {
            if (num[i] < num[smallestIndex]) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    void sort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            swap(num, i, findSmallest(num, i));
        }
    }


    public int[] twoSum(int[] num, int sum) {
        int check = 0;
        for (int i=0; i<num.length-1; i++) {
            for (int j=i+1; j<num.length; j++) {
                if (num[i] != num[j]) {
                    if (num[i] + num[j] == sum) {
                        System.out.print("Possible Sum: ");
                        System.out.println("[" + i + ", " + j + "]");
                        check = 1;
                        break;
                    }
                }
            }
        }

        if(check == 0) {
            System.out.println("Possible Sum: -1 (Not found)");
        }
        return num;

    }

    public static void main(String[] args) {

        TwoSum sorter = new TwoSum();
        int[] num = {7, 5, 3, 3, 2, 1, 4, 6, 12, 17};
        System.out.print("Unsorted Array: [");
        for (int i=0; i< num.length-1; i++) {
            System.out.print(num[i] + ", ");
        }
        System.out.println(num[num.length-1] + "]");


        int sum = 12;

        sorter.sort(num);

        System.out.print("Sorted Array: [");
        for (int i=0; i< num.length-1; i++) {
            System.out.print(num[i] + ", ");
        }
        System.out.println(num[num.length-1] + "]");


        System.out.println("Sum: " + sum);


        sorter.twoSum(num, sum);

    }
}
