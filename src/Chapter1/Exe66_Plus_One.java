package Chapter1;

import java.util.Arrays;

public class Exe66_Plus_One {

    public int[] plusOne(int[] digits) {
        int num = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + num;
            digits[i] = tmp % 10;
            num = tmp / 10;
            if (num == 0)
                break;
        }
        if (num > 0) {
            digits = new int[digits.length + 1];
            digits[0] = num;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9,9};
        new Exe66_Plus_One().plusOne(digits);
        System.out.println(Arrays.toString(digits));
    }

}
