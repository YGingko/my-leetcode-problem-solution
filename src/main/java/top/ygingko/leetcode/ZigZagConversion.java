package top.ygingko.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 0) {
            return null;
        }

        if (numRows == 1) {
            return s;
        }

        int len = s.length();
        char[] chs = s.toCharArray();
        int index = 0;
        char[] result = new char[len];
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j += 2*(numRows-1)) {

                int temp = j + i;
                if (temp < len && !set.contains(temp)) {
                    result[index++] = chs[temp];
                    set.add(temp);
                }

                temp = j + 2*(numRows-1) - i;
                if (temp < len && !set.contains(temp)) {
                    result[index++] = chs[temp];
                    set.add(temp);
                }
            }
        }

        return new String(result).trim();
    }

    public static void main(String[] args) {
        ZigZagConversion conversion = new ZigZagConversion();

        int num = 3;
        String s = "PAYPALISHIRING";
//        s = "ABCD";

        System.out.println(conversion.convert(s, num));
    }
}
