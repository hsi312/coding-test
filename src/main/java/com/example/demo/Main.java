package com.example.demo;

import java.util.*;

public class Main {

    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ')') {
                stack.add(str.charAt(i));
            } else {
                while (stack.pop() != '(');
            }
        }

        for (char c : stack) {
            answer += c;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}