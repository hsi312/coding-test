package com.example.demo.practice;

import java.util.*;

public class Main {

    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        int a = 1;
        int b = 1;
        answer.add(a);
        answer.add(b);
        for (int i = 2; i < n; i++) {
            int sum = a + b;
            answer.add(sum);
            a = b;
            b = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int x : T.solution(n)) {
            System.out.print(x + " ");
        }
    }
}
