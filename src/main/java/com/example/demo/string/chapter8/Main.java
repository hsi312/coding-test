package com.example.demo.string.chapter8;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "YES";
        char[] s = str.toLowerCase().replaceAll("[^a-z]", "").toCharArray();
        int lt = 0;
        int rt = s.length - 1;
        while (lt < rt) {
            if (s[lt] == s[rt]) {
                lt ++;
                rt --;
            } else {
                answer = "NO";
                break;
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
