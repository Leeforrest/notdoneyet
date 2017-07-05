package array;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 给定一个整数，表现形式是一个数组，比如123, 表示为{1,2,3}， 给这个数+1
 * author: Forrest
 * date: 2017/7/4
 * topic from ：https://leetcode.com/problems/plus-one/#/description
 * ref : https://siddontang.gitbooks.io/leetcode-solution/content/array/plus_one.html
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {

        int forward = 1;
        for(int i=digits.length-1 ; i>=0 ; i--) {
            int plus = digits[i] + forward;
            int div = plus/10;
            if(div > 0) {
                digits[i] = plus%10;
                forward = div;
            } else {
                digits[i] = plus;
                forward = 0;
            }
        }
        if(forward > 0) {
            int[]dest = new int[digits.length+1];
            dest[0] = forward;
            System.arraycopy(digits, 0, dest, 1, dest.length-1);
            return dest;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        int[]array = {1 , 9 , 9};
        array = new PlusOne().plusOne(array);
        for (int j : array) {
            System.out.println(j);
        }
    }
}
