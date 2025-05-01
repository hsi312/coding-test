package com.example.demo.string.chapter7;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "YES";

        char[] c = str.toLowerCase().toCharArray();
        int lt = 0;
        int rt = c.length - 1;

        while (lt < rt) {
            if (c[lt] != c[rt]) {
                answer = "NO";
                break;
            }
            lt ++;
            rt --;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        System.out.println(T.solution(kb.next()));
    }
}
