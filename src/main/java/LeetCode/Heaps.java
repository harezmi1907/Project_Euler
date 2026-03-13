package LeetCode;

import java.util.*;

public class Heaps {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(1);
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(4);
        System.out.println(minHeap.isEmpty());
        System.out.println(maxHeap);
        minHeap.add(2);
        maxHeap.add(7);
        System.out.println(minHeap);
        System.out.println(maxHeap);
        System.out.println(minHeap.poll());
        System.out.println(maxHeap.peek());
        System.out.println(minHeap);
        System.out.println(maxHeap);

        System.out.println(maxHeap.toArray()[0]);

        System.out.println(new Random().nextInt(10));;
    }
}

 class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);  // n - k gives us the index of the k-th largest
    }

    // Quickselect function to partition the array and find the k-th element
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];  // If the array contains only one element
        }

        // Choose a pivot index
        int pivotIndex = partition(nums, left, right);

        // If the pivot is in its final sorted position
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            // Go left
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            // Go right
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    // Partition function (similar to the one in Quicksort)
    private int partition(int[] nums, int left, int right) {
        // Choose the rightmost element as pivot
        int pivot = nums[right];
        int i = left;

        // Reorder the array so that elements less than pivot are on the left, and elements greater are on the right
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        // Place the pivot element in the correct position
        swap(nums, i, right);
        return i;  // Return the index of the pivot
    }

    // Swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4, 7, 7};
        int k = 2;  // Find the 2nd largest element
        System.out.println("The " + k + "-th largest element is: " + solution.findKthLargest(nums, k));  // Output: 5

        int i = 0;
        while(i++ < 10) {
            System.out.println(i);
        }
    }
}

class Solution {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for(int num : arr){
            min = min < num ? min : num;
            max = max > num ? max : num;
        }
        System.out.println("min:" + min + " - max:" + max);
        int[] sorted = new int[max-min+1];
        for(int num : arr){
            sorted[num-min] = 1;
        }
        System.out.println(Arrays.toString(sorted));
        int minDiff = max-min;
        int n1 = min;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i < max-min + 1; i++){
            int n2;
            if (sorted[i] == 1) {
                n2 = i+min;
            } else {
                continue;
            }
            int diff = Math.abs(n2-n1);
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(List.of(n1, n2));
            } else if (diff == minDiff) {
                result.add(List.of(n1, n2));
            }
            System.out.println("n1:" + n1 + " - n2:" + n2 + " - i:" + i);
            n1 = n2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        System.out.println(minimumAbsDifference(arr));
        Object xx = null;
        xx.toString();
    }
}

class Solution2 {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        // Initialize the auxiliary array `line`.
        // Keep a record of the minimum element and the maximum element.
        int minElement = arr[0];
        int maxElement = arr[0];
        for (int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
        }
        int shift = -minElement;
        int[] line = new int[maxElement - minElement + 1];
        List<List<Integer>> answer = new ArrayList();

        // For each integer `num` in `arr`, we increment line[num + shift] by 1.
        for (int num : arr) {
            line[num + shift] = 1;
        }

        // Start from the index representing the minimum integer, initialize the
        // absolute difference `min_pair_diff` as a huge value such as
        // `max_element - min_element` in order not to miss the absolute
        // difference of the first pair.
        int minPairDiff = maxElement - minElement;
        int prev = 0;

        // Iterate over the array `line` and check if line[curr]
        // holds the occurrence of an input integer.
        for (int curr = 1; curr <= maxElement + shift; ++curr) {
            // If line[curr] == 0, meaning there is no occurrence of the integer (curr - shift)
            // held by this index, we will move on to the next index.
            if (line[curr] == 0) {
                continue;
            }

            // If the difference (curr - prev) equals `minPairDiff`, we add this pair
            // {prev - shift, curr - shift} to the answer list. Otherwise, if the difference
            // (curr - prev) is smaller than `minPairDiff`, we empty the answer list and add
            // the pair {curr - shift, prev - shift} to the answre list and update the `minPairDiff`
            if (curr - prev == minPairDiff) {
                answer.add(Arrays.asList(prev - shift, curr - shift));
            } else if (curr - prev < minPairDiff) {
                answer = new ArrayList();
                minPairDiff = curr - prev;
                answer.add(Arrays.asList(prev - shift, curr - shift));
            }

            // Update prev as curr.
            prev = curr;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        System.out.println(minimumAbsDifference(arr));
    }

    public static class Solution3 {
        static class Bucket {
            public boolean used = false;
            public int minval = Integer.MAX_VALUE;
            public int maxval = Integer.MIN_VALUE;
        }

        public static int maximumGap(int[] nums) {
            if (nums == null || nums.length < 2) return 0;

            int mini = Arrays.stream(nums).min().getAsInt(), maxi = Arrays.stream(
                            nums
                    )
                    .max()
                    .getAsInt();

            int bucketSize = Math.max(1, (maxi - mini) / (nums.length - 1)); // bucket size or capacity
            System.out.println("bucketSize:" + bucketSize);
            int bucketNum = (maxi - mini) / bucketSize + 1; // number of buckets
            Bucket[] buckets = new Bucket[bucketNum];
            System.out.println("bucketNum:" + bucketNum);

            for (int num : nums) {
                int bucketIdx = (num - mini) / bucketSize; // locating correct bucket
                if (buckets[bucketIdx] == null) buckets[bucketIdx] = new Bucket();

                buckets[bucketIdx].used = true;
                buckets[bucketIdx].minval = Math.min(
                        num,
                        buckets[bucketIdx].minval
                );
                buckets[bucketIdx].maxval = Math.max(
                        num,
                        buckets[bucketIdx].maxval
                );
            }

            int prevBucketMax = mini, maxGap = 0;
            for (Bucket bucket : buckets) {
                if (bucket == null || !bucket.used) continue;

                maxGap = Math.max(maxGap, bucket.minval - prevBucketMax);
                prevBucketMax = bucket.maxval;
            }

            return maxGap;
        }

        public static void main(String[] args) {
            int[] nums = {0,9,10,11,19,20,25,30,35,40,45,50,55,60,65,70,75,80,85,91,96,100};
            System.out.println(maximumGap(nums));
        }
    }
}