package com.example.demo.array.chapter5;
/**
 * 소수 구하기(에레토스테네스체 > 2~9 수의 배수를 제외하면 됨)
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * 예시 입력 1
 * 20
 *
 * 예시 출력 1
 * 8
 */

import java.util.Scanner;

public class Main {

    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            System.out.println("i:" + i);
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) {
                    System.out.println("j:" + j);
                    ch[j] = 1;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(T.solution(n));
    }
}
