package com.company;


//import com.sun.deploy.util.StringUtils;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }


    // Encode by counting successive letters
    // If resulting stirng is longer return the original
    public static String runLenEncode(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int counter = 1;

        char previous = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == previous) {
                counter++;
            } else {
                sb.append(counter).append(previous);
                counter = 1;
            }
            previous = current;
        }

        if (counter > 0) {
            sb.append(counter).append(previous);
        }

        if (sb.toString().length() > str.length()) {
            return str;
        } else {
            return sb.toString();
        }
    }

    public static void test1() {
        String test = "aaa";
        String expected = "3a";
        String ret = runLenEncode(test);
        if (!ret.equals(expected)) {
            throw new RuntimeException("Not equal");
        }
    }

    public static void test2() {
        String test = "";
        String expected = "";
        String ret = runLenEncode(test);
        if (!ret.equals(expected)) {
            throw new RuntimeException("Not equal");
        }
    }

    public static void test3() {
        String test = "abcfghtre";
        String expected = "abcfghtre";
        String ret = runLenEncode(test);
        if (!ret.equals(expected)) {
            throw new RuntimeException("Not equal");
        }
    }

    public static void test4() {
        String test = "treeeeeeeeeee";
        String expected = "1t1r11e";
        String ret = runLenEncode(test);
        if (!ret.equals(expected)) {
            throw new RuntimeException("Not equal");
        }
    }



}
