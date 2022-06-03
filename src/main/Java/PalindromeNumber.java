package main.Java;

import javax.swing.text.ViewFactory;
import java.util.Arrays;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {

        char[] arr =   String.valueOf(x).toCharArray();
        char[] temp_arr = arr.clone();
         int temp = arr.length % 2;
         for (int i = 0; i < (arr.length - temp)/2;i++){
             char temp2 = arr[i];
             arr[i]= arr[arr.length - i - 1];
             arr[arr.length - i - 1] = temp2;
         }
         boolean a = Arrays.equals(arr, temp_arr);
        return a;
    }


    public static void main(String[] args) {
        int n = 5;
        boolean result = isPalindrome(n);
        System.out.println(result);
    }
}
