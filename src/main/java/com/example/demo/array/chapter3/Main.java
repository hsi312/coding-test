package com.example.demo.array.chapter3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public ArrayList<String> solution(int n, int[] a, int[] b) {
        ArrayList<String> answer = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (a[i] == 1 && b[i] == 2) {
                answer.add("B");
            } else if (a[i] == 2 && b[i] == 3) {
                answer.add("B");
            } else if (a[i] == 3 && b[i] == 1) {
                answer.add("B");
            } else if (a[i] == b[i]) {
                answer.add("D");
            } else {
                answer.add("A");
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = kb.nextInt();
        }
        for (String s : T.solution(n, a, b)) {
            System.out.println(s);
        }
    }
}
