package com.example.demo.string.chapter10.practice;

import java.util.Scanner;

public class Main {

    public int[] solution(String s, char c) {
        int[] answer = new int[s.length()];
        char[] x = s.toCharArray();
        int p = 100;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == c) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p = 100;
        for (int i = x.length - 1; i >= 0; i--) {
            if (x[i] == c) {
                p = 0;
            } else {
                p ++;
                answer[i] = Math.min(p, answer[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        for (int x : T.solution(str, c)) {
            System.out.print(x + " ");
        }
    }
}
