package com.example.demo.string.chapter12;

import java.util.Scanner;

public class Main {

    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        s = s.replace("#", "1").replace("*", "0");
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7);
            int num = Integer.parseInt(tmp, 2);
            answer.append((char)num);
            s = s.substring(7);

        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String s = kb.next();
        System.out.print(T.solution(s, n));
    }
}
