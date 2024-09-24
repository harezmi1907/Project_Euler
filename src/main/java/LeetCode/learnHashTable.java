package LeetCode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class learnHashTable {

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

    @Test
    public void containsDuplicate() {
        int[] nums = {1,2,3,4};
        Set<Integer> set = new HashSet<>();
        boolean result = false;
        for (int num : nums) {
            if(!set.add(num)) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }

    @Test
    public void singleNumber() {
        int[] nums = {4};
        Arrays.sort(nums);
        int result = nums[0];
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] != nums[i+1]) {
                result = nums[i];
                break;
            } else if(i == len - 3) {
                result = nums[i+2];
            }
            i++;
        }
        System.out.println(result);
    }

    @Test
    public void singleNumber2() {
        int[] nums = {4,2,1,2,1,4,5};
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        System.out.println(set.iterator().next());
    }

    @Test
    public void singleNumber3() {
        int[] nums = {0,0,1,2,1,4,4,2};
        int result = -1;
        HashMap<Integer, Integer> hash_table = new HashMap<>();
        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                result = i;
            }
        }
        System.out.println(result);
        System.out.println(hash_table);
    }

    @Test
    public void twoSum() {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = new int[2];
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(target-nums[i], i); //3-0, 4-1, 2-2
        }
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) != i) {
                    result[0] = map.get(nums[i]);
                    result[1] = i;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void twoSum2() {
        int[] nums = {3,2,4};
        int target = 6;
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len-1; i++) {
            for (int j = 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    map.put(i,j);
                }
            }
        }
        System.out.println(map);
    }

    @Test
    public void twoSum3() {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = new int[] {};
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                result = new int[] {map.get(nums[i]), i};
            }
            map.put(target-nums[i], i);
        }
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void firstUniqChar() {
        String s = "aadadaad";
        int result = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], -1);
                continue;
            }
            map.put(chars[i], i);
        }
        if (map.isEmpty()) result = -1;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            if (index != -1 && result > index) {
                result = index;
            }
        }
        result = result == Integer.MAX_VALUE ? -1 : result;
        System.out.println(result);
    }

    @Test
    public void firstUniqChar2() {
        String s = "loveleetcode";
        int result = -1;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
                continue;
            }
            map.put(c, i);
        }
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) != -1) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    @Test
    public void containsNearbyDuplicate() {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        boolean result = false;

        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                int index = i - map.get(nums[i]);
                if (k >= index) {
                    result = true;
                    break;
                }
            }
            map.put(nums[i], i);
        }
        System.out.println(result);
    }
}
