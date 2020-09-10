package com.first.leetcode.Array;

/**
 *
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int A =0, B = 0;
        for (int i = 0; i < secret.length(); i++) {
            /*if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            }else B++;*/
            for (int j = 0; j < secret.length(); j++) {
                if (secret.charAt(j) == guess.charAt(i)) {
                    char tmp = secret.charAt(j);
                    if (secret.indexOf(tmp) == guess.indexOf(tmp)) {
                        A++;
                    } else B++;
                }
            }
        }
        return A + "A" + B + "B";
    }
}
