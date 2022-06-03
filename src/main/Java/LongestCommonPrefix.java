package main.Java;

import java.io.StringReader;
import java.time.temporal.Temporal;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        boolean is_validate = true;
        String fin_str = "";
        int a = 0;
        try {
            while (is_validate) {
                char[] temp_1 = strs[0].toCharArray();
                for (String i : strs) {
                    char[] temp_2 = i.toCharArray();
                    if (temp_1[a] != temp_2[a]) {
                        is_validate = false;
                        break;
                    }
                }
                if (is_validate) {
                    fin_str += temp_1[a];
                    a++;
                }
            }
        }
        finally {
            return fin_str;
        }
    }

    public static void main(String[] args) {

        String[] main  = {"flower","flow","floight"};
        String s = longestCommonPrefix(main);
        System.out.println(s);


    }
}
