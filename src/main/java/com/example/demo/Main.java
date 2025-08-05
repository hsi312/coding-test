package com.example.demo;

import java.util.*;

public class Main {

    public int solution(String str) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (c == '+') stack.push(num1 + num2);
                else if (c == '-') stack.push(num1 - num2);
                else if (c == '*') stack.push(num1 * num2);
                else if (c == '/') stack.push(num1 / num2);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}