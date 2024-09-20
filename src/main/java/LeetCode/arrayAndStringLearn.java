package LeetCode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class arrayAndStringLearn {
//    public static void main(String[] args) {
//        List<Integer> v1;
//        Integer[] a = {0, 1, 2, 3, 4};
//        v1 = new ArrayList<>(Arrays.asList(a));
//        List<Integer> v3 = new ArrayList<>(v1);     // make an actual copy
//        v3.set(0, -1);
//        System.out.println(v3);
//        // 8. sort
//        Collections.sort(v3);
//        // 9. add new element at the end of the vector
//        v3.add(-1);
//        System.out.println(v3);
//        v3.add(1, 6);
//        System.out.println(v3);
//        // 10. delete the last element
//        v3.remove(v3.size() - 1);
//        System.out.println(v3);
//    }

    @Test
    public void pivotIndex() {
//        int[] nums = {1,7,3,6,5,6};
//        int[] nums = {1,2,3};
        int[] nums = {2,1,-1};
        int len = nums.length;
        int index = -1;
        int[] sumLeft = new int[len];
        int[] sumRight = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j<i) {
                    sumLeft[i] += nums[j];
                }
                if (j>i) {
                    sumRight[i] += nums[j];
                }
            }
            if (sumLeft[i] == sumRight[i]) {
                index = i;
            }
        }

        System.out.println(index);
        System.out.println(index == -1 ? "not equal" : nums[index] + "->" + sumRight[index] + ":" + sumLeft[index]);
    }


    @Test
    public void dominantIndex() {
//        int[] nums  = {3,6,1,0};
        int[] nums  = {1,2,3,4};
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < len; i++) {
            if ( 2 * nums[i] > max && maxIndex != i) {
                maxIndex = -1;
                break;
            }
        }

        System.out.println(maxIndex);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void plusOne() {
        int[] nums  = {9,9,9,9};
//        int[] nums  = {1,2,3,4};
        int len = nums.length;
        int[] result = new int[len + 1];

        for (int i = len-1; i >= 0; i--) {
            nums[i] += 1;
            if (nums[i] < 10) {
                result = nums;
                break;
            } else {
                nums[i] %= 10;
                if (i == 0) {
                    result[i] = 1;
                    for (int j = 0; j < len ; j++) {
                        result[j+1] = nums[i];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void generate() {
        int numRows = 5;
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> inner = new ArrayList<>(i+1);
            inner.add(1);
            for (int j = 0; j < i; j++) {
                if (j+1 == i) {
                    inner.add(1);
                } else {
                    inner.add(j + 1, result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
                }
            }
            result.add(inner);
        }
        System.out.println(result);
    }

    @Test
    public void addBinary() {
        String a = "1", b = "11";
        String result = "";
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        int lenB = b1.length;
        int lenA = a1.length;
        if (lenB > lenA) {
            char[] temp = a1;
            a1 = b1;
            b1 = temp;
            lenA = a1.length;
            lenB = b1.length;
        }
        int temp = 0;
        for (int i = 0; i < lenA; i++) {
            int sum = 0;
            if (lenB > i) {
                sum = b1[lenB - 1 - i] + a1[lenA - 1 - i] + temp - 96;
            } else {
                sum = a1[lenA - 1 - i] + temp - 48;
            }
            if ( sum == 3) {
                result = "1" + result;
                temp = 1;
            } else if ( sum == 2) {
                result = "0" + result;
                temp = 1;
            } else {
                result = sum + "" + result;
                temp = 0;
            }
        }
        if (temp == 1) {
            result = "1" + result;
        }
        System.out.println(result);
    }

    @Test
    public void strStr() {
        String haystack = "mississippi", needle = "iss";
        int index = -1;
        int len = haystack.length();
        int len2 = needle.length();
        if (len2 > len) {
            return;
        }
        Outer:
        for (int i = 0; i < len; i++) {
            if (needle.charAt(0) == haystack.charAt(i)) {
                for (int j = 1; j < len2; j++) {
                    if (i+j == len) {
                        return;
                    }
                    if (needle.charAt(j) != haystack.charAt(i+j)) {
                        continue Outer;
                    }
                }
                index = i;
                break;
            }
        }
        System.out.println(index);
        System.out.println(haystack.indexOf(needle));
    }

    @Test
    public void longestCommonPrefix() {
        String[] strings = {"ab","a"};
        String prefix = "";
//        Arrays.sort(strings);
//        System.out.println(Arrays.toString(strings));

        OUTER:
        for (int i = 0; i < strings[0].length(); i++) {
            for (int j = 1; j < strings.length; j++) {
                if (strings[j].length() <= i || strings[0].charAt(i) != strings[j].charAt(i)) {
                    break OUTER;
                }
            }
            prefix += strings[0].charAt(i);
        }
        System.out.println(prefix);
    }

    @Test
    public void reverseString() {
//        String[] s = {"h","e","l","l","o"};
        String[] s = {"H","a","n","n","a","h"};
        int j = s.length-1;
        for (int i = 0; i < j; i++) {
            String temp = s[j];
            s[j--] = s[i];
            s[i] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    @Test
    public void arrayPairSum() {
//        String[] s = {"h","e","l","l","o"};
        int[] nums = {6,2,6,5,1,2};
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i++];
        }
        System.out.println(sum);
    }

    @Test
    public void rotate1() {
        int[] nums = {1,2,3,4,5,6,7};
        int len = nums.length;
        int[] result = new int[len];
        int k = 3;
        for (int i = 0; i < len; i++) {
            if (i+k < len) {
                result[i + k] = nums[i];
            } else {
                result[i+k-len] = nums[i];
            }
        }
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void rotate2() {
        int[] nums = {1,2,3};
        int k = 2;
        int len = nums.length;

        if (len == 1 || len - k == 0 ) return;
        if (k > len) {
            k %= len;
        }
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i+k < len) {
                if (i<k){
                    temp[i+k] = nums[i+k];
                    nums[i+k] = nums[i];
                } else {
                    temp[i + k] = nums[i + k];
                    nums[i + k] = temp[i];
                }
            } else {
                if (i<k){
                    nums[i + k - len] = nums[i];
                } else {
                    nums[i + k - len] = temp[i];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void rotate() {
        int[] nums = {6,2,3,5,1,2,1,1,2,4,5};
        int len = nums.length;
        int k = 2;
        int temp1 = nums[0];
        for (int i = 0; i < len-k; i++) {
            int temp2 = nums[i+1];
            nums[i+k] = temp1;
            temp1 = temp2;
        }
//        for (int i = 0; i < k; i++) {
//            int temp2 = nums[len-k+i];
//            nums[i] = temp1;
//            temp1 = temp2;
//        }
        System.out.println(Arrays.toString(nums));
    }

    public static class MyHashSet {

        Bucket[] myBucket;
        int hashKey;
        int bucketSize;
        int keySize = 1001001;

        public MyHashSet() {
            //prime number around the square root of key size
            this.hashKey = 1001;
            this.bucketSize = keySize / hashKey;
            this.myBucket = new Bucket[hashKey];
        }

        public int hash(int key) {
            return key % hashKey;
        }

        public int index(int key) {
            return key / hashKey;
        }

        public void add(int key) {
            int hash = hash(key);
            int index = index(key);
            Bucket newBucket = myBucket[hash];
            if (newBucket == null) {
                myBucket[hash] = new Bucket(bucketSize);
            }
            myBucket[hash].add(index, key);
        }

        public void remove(int key) {
            int hash = hash(key);
            int index = index(key);
            if (myBucket[hash] == null) {
                return;
            }
            myBucket[hash].remove(index);
        }

        public boolean contains(int key) {
            int hash = hash(key);
            int index = index(key);
            if (myBucket[hash] == null) {
                return false;
            } else {
                return myBucket[hash].contains(index);
            }
        }

        private class Bucket {
            int[] bucket;

            public Bucket(int bucketSize) {
                this.bucket = new int[bucketSize];
                for (int i = 0; i < bucketSize; i++) {
                    bucket[i] = -1;
                }
            }

            public void add(int index, int key) {
                bucket[index] = key;
            }

            public void remove(int index) {
                bucket[index] = -1;
            }

            public boolean contains(int index) {
                return bucket[index] != -1;
            }
        }
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        int key = 1000000;
        obj.add(key);
        obj.add(1);
        obj.remove(key);
        boolean param_3 = obj.contains(key);
        boolean param_2 = obj.contains(1);
        obj.remove(0);
        System.out.println(param_3 + "\n" + param_2);
    }
}
