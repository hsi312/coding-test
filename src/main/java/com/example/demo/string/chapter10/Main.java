package com.example.demo.string.chapter10;
/**
 10. 가장 짧은 문자거리
 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

 입력
 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 문자열의 길이는 100을 넘지 않는다.

 출력
 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

 예시 입력 1
 teachermode e

 예시 출력 1
 1 0 1 2 1 0 1 2 2 1 0
 */

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
                p++;
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
