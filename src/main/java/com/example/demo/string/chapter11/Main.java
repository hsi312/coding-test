package com.example.demo.string.chapter11;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        StringBuilder answer = new StringBuilder();
        str = str + " ";
        char[] s = str.toCharArray();
        int cnt = 1;
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] == s[i+1]) {
                cnt++;
            } else {
                answer.append(s[i]);
                if (cnt > 1) {
                    answer.append(cnt);
                }
                cnt = 1;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }
}
