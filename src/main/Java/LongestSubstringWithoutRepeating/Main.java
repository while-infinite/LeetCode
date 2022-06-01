package main.Java.LongestSubstringWithoutRepeating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "pwwkew";

        char[] arr = s.toCharArray();


        List<Character> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        String write = "";

        for (int i = 0; i < arr.length; i++) {
            if (temp.contains(arr[i])) {
                for (Character c : temp)
                    write += String.valueOf(c);

                result.add(write);

                while (temp.contains(arr[i]))
                    temp.remove(0);
                write = "";
            }

            if (i == arr.length - 1 && !temp.contains(arr[i])) {
                temp.add(arr[i]);
                for (Character c : temp) {
                    write += String.valueOf(c);
                    result.add(write);
                }
            } else
                temp.add(arr[i]);
        }


        int maxSize = result.get(0).length();
        String characters = result.get(0);

        for (int i = 1; i < result.size(); i++) {
            if (result.get(i).length() > maxSize) {
                maxSize = result.get(i).length();
                characters = result.get(i);
            }
        }

        System.out.println("The answer is " + characters + ", with the length of " + maxSize);

    }
}
