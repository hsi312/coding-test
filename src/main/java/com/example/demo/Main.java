package com.example.demo;

import java.util.*;

public class Main {
    static int n;
    static int m;
    static int answer = Integer.MIN_VALUE;
    static int[] time;
    static int[] score;

    public void DFS(int L, int sum, int t) {
        if (t > m) {
            return;
        }
        if (L == n) {
            answer = Math.max(sum, answer);
        } else {
            DFS(L + 1, sum + score[L], time[L] + t);
            DFS(L + 1, sum, t);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        time = new int[n];
        score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        T.DFS(0, 0, 0);
        System.out.println(answer);
    }
}