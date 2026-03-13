package LeetCode;

public class BitwiseOps {
    public static void main(String[] args) {
//        System.out.println(convertToBase7(100));
//        System.out.println(Integer.toString(100, 7));
//        System.out.println(toHex2(-1));
        System.out.println(getSum(1,5));
        System.out.println(getSum2(1,5));
        System.out.println(getSum3(1,5));
    }
    public static String convertToBase7(int num) {
        String str = "";
        String sign = "";
        if(num<0) {
            sign = "-";
            num *= -1;
        } else if (num == 0) {
            return "0";
        }
        while (num > 0) {
            str = num%7 + str;
            num /= 7;
        }
        return sign + str;
    }

    public static String toHex(int num) {
        if(num == 0) return "0";
        long val = num;
        if(num < 0) val = (long)(Math.pow(2,32) + num);
        StringBuilder res = new StringBuilder();
        while(val != 0){
            int remainder = (int) (val % 16);
            val = val/16;
            if(remainder >= 10) res.append((char)(remainder+87));
            else res.append(remainder);
        }
        return res.reverse().toString();
    }

    public static String toHex2(int num) {
        if(num == 0) return "0";
        int val = num;
        StringBuilder res = new StringBuilder();
        while(val != 0){
            int remainder = val & 0xF; // mask the last 4 bits (0xF is hexadecimal for 15)
            val >>>= 4; // unsigned right shift by 4 bits
            if(remainder >= 10) res.append((char)(remainder + 87));
            else res.append(remainder);
        }
        return res.reverse().toString();
    }

    public static int hammingWeight(int n) {
        if(n == 0) return 0;
        int c = 0;
        while(n != 0){
            if(n%2 == 1) c++;
            n /= 2;
        }
        return c;
    }

    public static int hammingWeight2(int n) {
        if(n == 0) return 0;
        int c = 0;
        while(n != 0){
            c += (n & 1);
            n >>>= 1;
        }
        return c;
    }

    public static int getSum2(int a, int b) {
        while (b != 0) {
            int answer = a ^ b;
            int carry = (a & b) << 1;
            a = answer;
            b = carry;
        }
        return a;
    }

    public static int getSum(int a, int b) {
        return (int) Math.log10(Math.pow(10, a) * Math.pow(10, b));
    }

    public static int getSum3(int a, int b) {
        if (b != 0) {
            int answer = a ^ b;
            int carry = (a & b) << 1;
            return getSum3(answer, carry);
        }
        return a;
    }
}
