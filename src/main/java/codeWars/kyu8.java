package codeWars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ykeskin
 * @since 10/14/2020
 */
public class kyu8 {


    public static String solution(String str) {
        return new StringBuilder(str).reverse().toString();
    }


    public static int findSmallestInt(int[] args) {
//        return Arrays.stream(args).reduce(Integer.MAX_VALUE, Math::min);
//        return IntStream.of(args).min().getAsInt();
        Arrays.sort(args);
        return args[0];
    }

    @Test
    public void example1() {
        int expected = 11;
        int actual = kyu8.findSmallestInt(new int[]{78, 56, 232, 12, 11, 43});
        assertEquals(expected, actual);

        expected = 11;
        actual = kyu8.findSmallestInt(new int[]{78, 56, 232, 12, 11, 43});
        assertEquals(expected, actual);

        expected = Integer.MIN_VALUE;
        actual = kyu8.findSmallestInt(new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE});
        assertEquals(expected, actual);
    }

}
