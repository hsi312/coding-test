package com.example.demo;

import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] answer;

    public void DFS(int L) {
        if (L == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                answer[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = new int[m];
        T.DFS(0);
    }
}