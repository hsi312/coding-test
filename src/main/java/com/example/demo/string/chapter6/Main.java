package com.example.demo.string.chapter6;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    public String solution2(String str) {
        StringBuilder answer = new StringBuilder();
        char[] s = str.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : s) {
            set.add(c);
        }
        for (Character c : set) {
            answer.append(c);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        System.out.println(T.solution2(kb.next()));
    }
}
