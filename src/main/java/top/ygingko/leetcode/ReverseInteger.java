package top.ygingko.leetcode;

/**
 * Created by Haitao Huang on 2017/12/13.
 * Description:
 * <p>
 * Copyright (c) 2017, 成都冰鉴信息科技有限公司
 * All rights reserved.
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
        }

        char[] chs = String.valueOf(Math.abs(x)).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chs.length-1; i >= 0; i--) {
            sb.append(chs[i]);
        }
        int rev = 0;
        try {
            rev = Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {
            return rev;
        }
        if (flag) {
            return -rev;
        } else {
            return rev;
        }
    }

    public static void main(String[] args) {
        ReverseInteger rs = new ReverseInteger();
        System.out.println(rs.reverse(1534236469));
    }
}
