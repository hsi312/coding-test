package com.example.demo.array.chapter4;

/**
 * 피보나치 수열
 * 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 *
 * 예시 입력 1
 * 10
 *
 * 예시 출력 1
 * 1 1 2 3 5 8 13 21 34 55
 */

import java.util.Scanner;

public class Main {

    public void solution(int n) {
        StringBuilder s = new StringBuilder();
        int a  = 1;
        int b = 1;
        s.append(1 + " " + 1);
        for (int i = 2; i < n; i++) {
            int sum = a + b;
            s.append(" ").append(sum);
            a = b;
            b = sum;
        }
        System.out.println(s);
    }

//    public ArrayList<Integer> solution(int n) {
//        ArrayList<Integer> answer = new ArrayList<>(n);
//        answer.add(1);
//        answer.add(1);
//        for (int i = 0; i < n-2; i++) {
//            int sum = answer.get(i) + answer.get(i + 1);
//            answer.add(sum);
//        }
//
//        return answer;
//    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.solution(n);
    }
}
