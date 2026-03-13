package LeetCode;

import org.junit.jupiter.api.Test;

import java.awt.datatransfer.StringSelection;
import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class learnHashTable {

    public static void main(String[] args) {
//        MyHashSet obj = new MyHashSet();
//        int key = 1000000;
//        obj.add(key);
//        obj.add(1);
//        obj.remove(key);
//        boolean param_3 = obj.contains(key);
//        boolean param_2 = obj.contains(1);
//        obj.remove(0);
//        System.out.println(param_3 + "\n" + param_2);
        System.out.println(1 << 5);
        System.out.println();


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

    @Test
    public void groupAnagrams() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        String[] strs = {"a"};
        Map<String, List<String>> map = new HashMap<>();

        for (String temp : strs) {
            char[] chars = temp.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(temp);
        }
        System.out.println(new ArrayList<>(map.values()));
    }


    @Test
    public void isValidSudoku() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = true;

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        OUTER:
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((board[i][j] != '.' && !set1.add(board[i][j])) || (board[j][i] != '.' && !set2.add(board[j][i]))) {
                    result = false;
                    break OUTER;
                }
            }
            set1 = new HashSet<>();
            set2 = new HashSet<>();
        }

        Set<Character> set3 = new HashSet<>();
        int si = 0;
        int sj = 0;
        int counter = 0;
        boolean flag = true;

        while(flag) {
            for (int i = si; i < 3 + si; i++) {
                for (int j = sj; j < 3 + sj; j++) {
                    if (board[i][j] != '.' && !set3.add(board[i][j])) {
                        result = false;
                        flag = false;
                    }
                }
                counter++;
            }
            if (counter %9 == 0) {
                si += 3;
                if (si == 9) {
                    result = false;
                    flag = false;
                }
                sj = 0;
                set3 = new HashSet<>();
                counter = 0;
            } else if (counter %3 == 0) {
                sj += 3;
                set3 = new HashSet<>();
            }
        }
        System.out.println(result);
    }

    @Test
    public void isValidSudoku2() {
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'7', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '7', '4', '.', '.', '.', '.', '6', '.'},
                {'1', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'5', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'3', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '9', '4', '1', '2', '3', '.', '5'},
                {'6', '.', '1', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = true;

        HashSet<Character>[] box = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            box[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {

            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();
            for (int j = 0; j < 9; j++) {

                if ((board[i][j] != '.' && !row.add(board[i][j])) || (board[j][i] != '.' && !column.add(board[j][i]))) {
                    result = false;
                    System.out.println("i:" + i + " - j:" + j);
                    System.out.println("1:" + result);
                    return;
                }
                int index = (i/3) * 3 + j/3;
//                System.out.println("i:" + i + " - j:" + j + " index:" + index + " value:" + board[i][j]);
                if (board[i][j] != '.' && !box[index].add(board[i][j])) {
                    result = false;
                    System.out.println("i:" + i + " - j:" + j);
                    System.out.println("box:" + result);
                    return;
                }
//                System.out.println(box[index]);
            }
        }
        System.out.println("box:" + Arrays.toString(box));
        System.out.println(true);
    }

    @Test
    public void isValidSudoku3() {
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'7', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '7', '4', '.', '.', '.', '.', '6', '.'},
                {'1', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'5', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'3', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '9', '4', '1', '2', '3', '.', '5'},
                {'6', '.', '1', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = true;

        for (int i = 0; i < 9; i++) {

            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();
            Set<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {

                if ((board[i][j] != '.' && !row.add(board[i][j])) || (board[j][i] != '.' && !column.add(board[j][i]))) {
                    result = false;
                    System.out.println("i:" + i + " - j:" + j);
                    System.out.println("1:" + result);
                    return;
                }
                int boxi = i/3 * 3 + j/3;
                int boxj = i%3 * 3 + j%3;
                if (board[boxi][boxj] != '.' && !box.add(board[boxi][boxj])) {
                    result = false;
//                    System.out.println("i:" + i + " - j:" + j);
                    System.out.println("box:" + result);
                    return;
                }
                System.out.println(box);
            }
        }
        System.out.println(true);
    }

    @Test
    public void isValidSudoku5() {
        char[][] A = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'.', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '5', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '.'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        for (int i = 0; i < 9; i++) {
            final int pos = i;
            if (!isValid(x -> A[pos][x]))  {System.out.println("1:" + false); return;}
            if (!isValid(x -> A[x][pos]))  {System.out.println("2:" + false); return;}
            if (!isValid(x -> A[(pos / 3) * 3 + x / 3][(pos % 3) * 3 + x % 3])) {System.out.println("3:" + false); return;}
        }
        System.out.println(true);
    }

    private static boolean isValid(IntFunction<Character> a) {
        Set<Character> set = new HashSet<>();
        return IntStream.range(0, 9).allMatch(x -> a.apply(x) == '.' || set.add(a.apply(x)));
    }


    @Test
    public void topKFrequent() {
        int[] nums = {1,1,1,1,1,1,2,2,2,3,4,4,4,4,4,5,5};
        int k = 3;
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            for (int i = k-1; i>=0; i--) {
                if(map.get(key) >= map.getOrDefault(result[i], 0)) {
                    if (i+1 < k) {
                        result[i+1] = result[i];
                    }
                    result[i] = key;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static class GFG {
        // Function to print permutations of string
        // This function takes three parameters:
        // 1. String
        // 2. Starting index of the string
        // 3. Ending index of the string.
        static void permute(char[] a, int l, int r)
        {
            // Base case
            if (l == r)
                System.out.println(new String(a));
            else {
                // Permutations made
                for (int i = l; i <= r; i++) {
                    // Swapping done
                    swap(a, l, i);

                    // Recursion called
                    permute(a, l + 1, r);

                    // Backtrack
                    swap(a, l, i);
                }
            }
        }

        // Function to swap characters at positions i and j in
        // the array
        static void swap(char[] arr, int i, int j)
        {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Driver Code
        public static void main(String[] args)
        {
            String str = "ABCD";
            int n = str.length();
            char[] arr = str.toCharArray();

            // Function call
            permute(arr, 0, n - 1);
        }
    }









}
