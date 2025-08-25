package com.example.demo;

import java.util.*;

public class Main {
    static int n, r;
    int[][] answer = new int[34][34];

    public int DFS(int n, int r) {
        if (answer[n][r] > 0) {
            return answer[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return answer[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        System.out.println(T.DFS(n, r));
    }
}