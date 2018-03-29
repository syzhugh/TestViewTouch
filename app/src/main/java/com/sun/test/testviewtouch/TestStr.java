package com.sun.test.testviewtouch;

public class TestStr {

    public static void main(String[] args) {

        // a1
        String a1 = new String("1");
        String a2 = new String("2");
        String newStr = a1 + a2;

        // a2
        String b1 = "111";
        String b2 = "222";
        String b3 = "111" + "222";
        String b4 = "111222";
        String b5 = "111" + b2;
        String b6 = b1 + b2;
        System.out.println(b3 == b4);
        System.out.println(b3 == b5);
        System.out.println(b3 == b6);

        // a3
        b5 = b5.intern();
        b6 = b6.intern();
        System.out.println(b3 == b5);
        System.out.println(b3 == b6);
    }
}
