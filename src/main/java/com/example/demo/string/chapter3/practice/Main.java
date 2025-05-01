package com.example.demo.string.chapter3.practice;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";
        String[] s = str.split(" ");
        int n = Integer.MIN_VALUE;
        for (String x : s) {
            int len = x.length();
            if (len > n) {
                n = len;
                answer = x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        System.out.println(T.solution(kb.nextLine()));
    }
}
