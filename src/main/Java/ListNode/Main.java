package main.Java.ListNode;

import java.math.BigDecimal;

public class Main {

    public static String rec(ListNode l){
        String concat = String.valueOf(l.val);

        if(l.next == null)
            return concat;

        return concat + rec(l.next);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String convert1 = rec(l1);
        String convert2 = rec(l2);
        String charToString1 = "";
        String charToString2 = "";


        char[] stringToChar1 = convert1.toCharArray();
        char[] stringToChar2 = convert2.toCharArray();

        int secondPart = stringToChar1.length - 1;
        for (int i = 0; i < stringToChar1.length; i++, secondPart--) {
            if(i < stringToChar1.length/ 2) {
                char temp = stringToChar1[i];
                stringToChar1[i] = stringToChar1[secondPart];
                stringToChar1[secondPart] = temp;
            }
            charToString1 += stringToChar1[i];
        }

        secondPart = stringToChar2.length - 1;
        for (int i = 0; i < stringToChar2.length; i++, secondPart--) {
            if(i < stringToChar2.length / 2) {
                char temp = stringToChar2[i];
                stringToChar2[i] = stringToChar2[secondPart];
                stringToChar2[secondPart] = temp;
            }
            charToString2 += stringToChar2[i];
        }



        System.out.println(charToString1 + " : " + charToString2);
        BigDecimal node1 = new BigDecimal(charToString1);
        BigDecimal node2 = new BigDecimal(charToString2);
        String temp = String.valueOf(node1.add(node2));
        char[] arr = temp.toCharArray();
        String[] stringArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++)
            stringArr[i] = String.valueOf(arr[i]);

        ListNode result = new ListNode(Integer.parseInt(stringArr[stringArr.length - 1]));
        ListNode temp2 = result;
        for (int i = arr.length - 2; i >= 0; i--) {
            temp2.next = new ListNode(Integer.parseInt(stringArr[i]));
            temp2 = temp2.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);


        ListNode listNode2 = new ListNode(9);
        ListNode listNode21 = new ListNode(9,listNode2);
        ListNode listNode22 = new ListNode(9,listNode21);
        ListNode listNode23 = new ListNode(9,listNode22);
        ListNode listNode24 = new ListNode(9,listNode23);
        ListNode listNode25 = new ListNode(9,listNode24);
        ListNode listNode26 = new ListNode(9,listNode25);
        ListNode listNode27 = new ListNode(9,listNode26);
        ListNode listNode28 = new ListNode(9,listNode27);
        ListNode listNode29 = new ListNode(1,listNode28);



        ListNode result = addTwoNumbers(listNode1, listNode29);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
