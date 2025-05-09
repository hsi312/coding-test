package com.example.demo.stackQueue.chapter2;
/**
 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

 입력
 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

 출력
 남은 문자만 출력한다.

 예시 입력 1
 (A(BC)D)EF(G(H)(IJ)K)LM(N)

 예시 출력 1
 EFLM
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }
        for (char s : stack) {
            answer += s;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
