package com.example.demo.practice;

import java.util.*;

public class Main {

    public void solution(String s) {
        s = s + " ";
        char[] c = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == c[i + 1]) {
                cnt++;
            } else {
                builder.append(c[i]);
                if (cnt > 1) {
                    builder.append(cnt);
                }
                cnt = 1;
            }
        }
        System.out.println(builder);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        T.solution(s);
    }
}
