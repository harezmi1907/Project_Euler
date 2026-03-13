package LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Sorts {

    public static void main(String[] args) {
        //1100
        System.out.println(Integer.toBinaryString(12 >> 1));
        System.out.println(Integer.toBinaryString(12 >>> 1));
    }
    public static class InsertionSort {

        // Function to perform Insertion Sort
        public static void insertionSort(int[] array) {
            int n = array.length;

            // Traverse through the array from the second element to the end
            for (int i = 1; i < n; i++) {
                // Store the current element
                int key = array[i];

                // Move elements of array[0...i-1] that are greater than key
                // to one position ahead of their current position
                int j = i - 1;
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j]; // Shift the element
                    j--;
                }

                // Place the key at the correct position
                array[j + 1] = key;
            }
        }

        // Function to print the array
        public static void printArray(int[] array) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int[] array = {12, 11, 13, 5, 6};

            System.out.println("Original Array:");
            printArray(array);

            // Perform Insertion Sort
            insertionSort(array);

            System.out.println("Sorted Array:");
            printArray(array);
        }
    }

    public static class Quicksort {
        public static void main(String[] args) {
            int[] myArray = {64, 34, 25, 12, 22, 11, 90, 5};
            quicksort(myArray, 0, myArray.length - 1);

            System.out.print("Sorted array: ");
            for (int value : myArray) {
                System.out.print(value + " ");
            }
        }

        public static void quicksort(int[] array, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(array, low, high);
                quicksort(array, low, pivotIndex - 1);
                quicksort(array, pivotIndex + 1, high);
            }
        }

        public static int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (array[j] <= pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;
            return i + 1;
        }
    }

    public static class MergeSort {
        public static void main(String[] args) {
            double[] unsortedArr = {3, 7, 6, -10, 15, 23.5, 55, -13};
            double[] sortedArr = mergeSort(unsortedArr);
            System.out.println("Sorted array: " + Arrays.toString(sortedArr));
        }

        public static double[] mergeSort(double[] arr) {
            if (arr.length <= 1) {
                return arr;
            }

            int mid = arr.length / 2;
            double[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
            double[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);

            double[] sortedLeft = mergeSort(leftHalf);
            double[] sortedRight = mergeSort(rightHalf);

            return merge(sortedLeft, sortedRight);
        }

        public static double[] merge(double[] left, double[] right) {
            double[] result = new double[left.length + right.length];
            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    result[k++] = left[i++];
                } else {
                    result[k++] = right[j++];
                }
            }

            while (i < left.length) {
                result[k++] = left[i++];
            }

            while (j < right.length) {
                result[k++] = right[j++];
            }

            return result;
        }
    }

    @Test
    public void mergeSort2() {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        //Solution
        int i = m+n-1;
        m +=-1;
        n +=-1;
        while (i >= 0) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] > nums2[n]) {
                    nums1[i--] = nums1[m--];
                } else {
                    nums1[i--] = nums2[n--];
                }
            } else if (m >= 0){
                nums1[i--] = nums1[m--];
            } else if (n >= 0){
                nums1[i--] = nums2[n--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }


}
