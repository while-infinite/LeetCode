package main.Java;

import java.util.HashMap;
import java.util.Map;

public class RomanToString {
    public static void main(String[] args) throws Exception {

        int result = romanToInt("MCMXCIV");
        System.out.println(result);

    }

    public static int romanToInt(String s) {
        try {
            if (s.length() < 1 || s.length() > 15)
                throw new Exception();
        }catch (Exception e){
            System.out.println("Wrong quantity of characters!");
            return 0;
        }


        int sum = 0;
        boolean checkChar;
        char[] requiredChar = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        char[] arr = s.toCharArray();
        try {
            for (int i = 0; i < arr.length; i++) {
                checkChar = false;
                for (int j = 0; j < requiredChar.length; j++) {
                    if (arr[i] == requiredChar[j])
                        checkChar = true;

                    if (j == requiredChar.length - 1 && !checkChar)
                        throw new Exception();
                }
            }
        }catch (Exception e){
            System.out.println("Wrong characters!");
            return 0;
        }


        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        char previosChar = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'I' || arr[i] != 'L' || arr[i] != 'D') {
                if (arr[i] == 'V' && previosChar == 'I') {
                    sum += map.get('V') - map.get(previosChar) * 2;
                    continue;
                }
                if (arr[i] == 'X' && previosChar == 'I') {
                    sum += map.get('X') - map.get(previosChar) * 2;
                    continue;
                }
                if (arr[i] == 'L' && previosChar == 'X') {
                    sum += map.get('L') - map.get(previosChar) * 2;
                    continue;
                }
                if (arr[i] == 'C' && previosChar == 'X') {
                    sum += map.get('C') - map.get(previosChar) * 2;
                    continue;
                }
                if (arr[i] == 'D' && previosChar == 'C') {
                    sum += map.get('D') - map.get(previosChar) * 2;
                    continue;
                }
                if (arr[i] == 'M' && previosChar == 'C') {
                    sum += map.get('M') - map.get(previosChar) * 2;
                    continue;
                }
            }
            sum += map.get(arr[i]);
            previosChar = arr[i];

        }
        try {
            if (sum < 1 || sum > 3999)
                throw new Exception();
        }catch (Exception e){
            System.out.println("Sum should be in range: 1 - 3999!");
            return 0;
        }

        return sum;

    }
}
