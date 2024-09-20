package LeetCode;

import com.sun.jdi.request.BreakpointRequest;
import org.junit.jupiter.api.Test;

import java.awt.event.WindowFocusListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class arrayLearn {

    @Test
    public void findNumbers1() {
        int[] nums = {1555,901,482,1771};
        int evenNums = 0;
        for (int num : nums){
            String str = String.valueOf(num);
            System.out.println(str.length());
            if (str.length() % 2 == 0) {
                evenNums++;
            }
        }
        assert evenNums == 2;
    }

    @Test
    public void findNumbers2() {
        int[] nums = {1555,901,482,1771};
        int evenNums = 0;
        for (int num : nums) {
            int digits = 0;
            while (num > 0) {
                num /= 10;
                digits++;
            }
            if (digits % 2 == 0) {
                evenNums++;
            }
        }
        assert evenNums == 2;
    }

    @Test
    public void duplicateZeros() {
        int[] nums = {1,0,2,3,0,4,5,0};
        int len = nums.length;
        int[] temp = new int[len];
        int j = 0;
        for (int i=0; j<len; i++) {
            if (nums[i] == 0) {
                temp[j++] = 0;
                temp[j++] = 0;
            } else {
                temp[j] = nums[i];
                j++;
            }
        }
        nums = temp;
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void duplicateZeros2() {
        int[] nums = {1,0,2,3,0,4,5,0};
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        for (int i=0; i<len; i++) {
            if (nums[i] == 0) {
                for (int j=len-1; j>i; j--) {
                    nums[j] = nums[j-1];
                }
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    //solve this without using extra space and in O(n) time
    @Test
    public void duplicateZeros3() {
        int[] nums = {1,0,2,3,0,4,5,0};
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        for (int i=0; i<len; i++) {
            if (nums[i] == 0) {
                for (int j=len-1; j>i; j--) {
                    nums[j] = nums[j-1];
                }
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void removeElement() {
        int[] nums = {3,2,2,3};
        int val = 3;
        int len = nums.length;
        int k = 0;
        for (int i=len-1; i>=0; i--) {
            if (nums[i] == val) {
                nums[i] = nums[len-1-k];
                nums[len-1-k] = val;
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(len-k);
    }

    @Test
    public void removeDuplicates() {
        int[] nums = {0,0,0,1,1,1,2,2,3,3,4};
        int len = nums.length;
        int k = 0;
        for (int i=1; i<len; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(k+1);
    }

    @Test
    public void checkIfExist() {
        int[] nums = {-2,0,10,-19,4,6,-8};
        int len = nums.length;
        boolean result = false;

        A:
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                if (i != j && (nums[i] == 2 * nums[j] || (nums[i] % 2 == 0 && nums[j] == nums[i] / 2))) {
                    result = true;
                    break A;
                }
            }
        }
        System.out.println(nums[3] / 2);
        System.out.println(result);
    }

    @Test
    public void validMountainArray() {
        int[] nums = {5,3,2,1};
        int len = nums.length;
        boolean inc = true;

        if (len < 3) return;

        for (int i=0; i<len-1; i++) {
            if (nums[i] == nums[i+1]) {
                return;
            } else if (i == 0) {
                if (nums[i] >= nums[i+1]){
                    return;
                }
            } else if (inc) {
                if (nums[i] >= nums[i+1]){
                    inc = false;
                }
            } else {
                if (nums[i] < nums[i+1]){
                    return;
                }
            }
        }
        System.out.println(!inc);
    }

    @Test
    public void replaceElements() {
        int[] arr = {18,1,15,4,6,1};
        int len = arr.length;
        if (len == 1) {
            arr[0] = -1;
            return;
        }
        for (int i = 0; i < len-1; i++) {
            int max = Integer.MIN_VALUE;
            int index = 0;
            for (int j = i+1; j < len; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    index = j;
                }
            }
            for (int k = i; k < index; k++) {
                arr[k] = max;
            }
            i += index-i-1;
        }
        arr[len-1] = -1;
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void removeDuplicatesFromSortedArray() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = nums.length;
        int k = 0;
        for (int i=1; i<len; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
    }

    @Test
    public void moveZeroes() {
        int[] nums = {1,0,0,5,12,0};
        int len = nums.length;
        int zeroes = 0;
        for (int i = 0; i < len - zeroes; i++) {
            if (nums[i] == 0) {
                zeroes++;
                for (int j = i; j < len-1; j++) {
                    nums[j] = nums[j+1];
                }
                i--;
                nums[len-zeroes] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void heightChecker() {
        int[] heights = {1,1,4,2,1,3};
        int len = heights.length;
        int count = 0;
        int[] arr = Arrays.stream(heights).sorted().toArray();
        for (int i = 0; i < len; i++) {
            if (arr[i] != heights[i]) {
                count++;
            }
        }
        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }

    @Test
    public void heightChecker2() {
        int[] heights = {1,1,4,2,1,3};
        int len = heights.length;
        int count = 0;
        int[] arr = Arrays.stream(heights).sorted().toArray();
        for (int i = 0; i < len; i++) {
            if (arr[i] != heights[i]) {
                count++;
            }
        }
        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }
}
