package top.ygingko.leetcode;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        char[] chs = null;
        int max = 0;

        int len = s.length();
        char[] ss = s.toCharArray();

        char[] tchs;
        int tmax;
        for (int index = 0; index < len; index++) {
            tchs = new char[len];
            tmax = 1;
            tchs[index] = ss[index];
            for (int i = 1; i <= index && i + index < len; i++) {
                if (ss[index - i] != ss[index + i]) {
                    break;
                }
                tmax += 2;
                tchs[index+i] = ss[index+i];
                tchs[index-i] = ss[index-i];
            }

            if (max < tmax) {
                chs = tchs;
                max = tmax;
            }

            tchs = new char[len];
            tmax = 0;
            for (int i = 0; i <= index && i + index + 1 < len; i++) {
                if (ss[index - i] != ss[index + i + 1]) {
                    break;
                }
                tmax += 2;
                tchs[index-i] = ss[index-i];
                tchs[index+i+1] = ss[index+i+1];
            }

            if (max < tmax) {
                chs = tchs;
                max = tmax;
            }
        }

        return new String(chs).trim();
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();

        String s = "babad";
        s = "bb";
//        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(l.longestPalindrome(s));
    }
}
