package com.example.demo.string.chapter4.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // 특정 문자열 뒤집기
    public ArrayList<String> solution2(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String s : str) {
            char[] c = s.toCharArray();
            int lt = 0;
            int rt = s.length() - 1;
            while (lt < rt) {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(c);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i  = 0; i < n; i++) {
            str[i] = kb.next();
        }
        for (String s : T.solution2(n, str)) {
            System.out.println(s);
        }
    }
}
