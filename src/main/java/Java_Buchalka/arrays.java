package Java_Buchalka;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class arrays {

    public static void main(String[] args) {

    }

    @Test
    public void arrayChallengeSortByDescendingOrder() {
        long time = System.nanoTime();
        int len = 100;
        int[] numArray = createArrayWithRandomNumbers(len);
//        System.out.println(Arrays.toString(numArray));

        Arrays.sort(numArray);
//        System.out.println(Arrays.toString(numArray));

        int [] newNumArray = new int[len];
        for (int i = 0; i < len ; i++) {
            newNumArray[i] = numArray[len - 1 - i];
        }
//        System.out.println(Arrays.toString(newNumArray));
        System.out.println((System.nanoTime() - time) / 1000); //4987 for 10000
    }

    @Test
    public void arrayChallengeSortByDescendingOrder2() {
        long time = System.nanoTime();
        int len = 10000;
        int[] numArray = createArrayWithRandomNumbers(len);
//        System.out.println(Arrays.toString(numArray));

        int [] newNumArray = Arrays.copyOf(numArray, len);
        int temp;

        for (int i = 0; i < len - 1; i++) {
            if (newNumArray[i] < newNumArray[i + 1]) {
                temp = newNumArray[i];
                newNumArray[i] = newNumArray[i + 1];
                newNumArray[i + 1] = temp;
                i = -1;
            }
        }
//        System.out.println(Arrays.toString(newNumArray));
        System.out.println((System.nanoTime() - time) / 1000); // 110914574 for 10000
    }

    @Test
    public void arrayChallengeSortByDescendingOrder3() {
        long time = System.nanoTime();
        int len = 10000;
        int[] numArray = createArrayWithRandomNumbers(len);
//        System.out.println(Arrays.toString(numArray));

        int [] newNumArray = Arrays.copyOf(numArray, len);
        int temp;
        boolean flag = true;
        while(flag) {
            flag = false;
            for (int i = 0; i < len - 1; i++) {
                if (newNumArray[i] < newNumArray[i + 1]) {
                    temp = newNumArray[i];
                    newNumArray[i] = newNumArray[i + 1];
                    newNumArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
//        System.out.println(Arrays.toString(newNumArray));
        System.out.println((System.nanoTime() - time) / 1000); // 157297 for 10000
    }

    public static int[] createArrayWithRandomNumbers (int size) {
        int[] numArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numArray[i] = random.nextInt(10000);
        }
        return numArray;
    }

    @Test
    public void findMin() {
        long time = System.nanoTime();
        int[] nums = createArrayWithRandomNumbers(100000);
//        System.out.println(Arrays.toString(nums));
        int result = nums[0];
        for (int num : nums) {
            if(result > num) {
                result = num;
            }
        }
        System.out.println(result);
        System.out.println((System.nanoTime() - time) / 1000); // 6452 for 100000
    }

    @Test
    public void findMin2() {
        long time = System.nanoTime();
        int[] nums = createArrayWithRandomNumbers(100000);
//        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        int result = nums[0];
        System.out.println(result);
        System.out.println((System.nanoTime() - time) / 1000); // 33226 for 100000
    }

    @Test
    public void reverseArray() {
        long time = System.nanoTime();
        int[] nums = createArrayWithRandomNumbers(9);
        System.out.println(Arrays.toString(nums));
        int len = nums.length;
        for (int i = 0; i < len/2 ; i++) {
            int temp = nums[i];
            nums[i] = nums[len - 1 - i];
            nums[len - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println((System.nanoTime() - time) / 1000); // 33226 for 100000
    }
}
