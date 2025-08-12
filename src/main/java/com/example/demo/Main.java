package com.example.demo;

import java.util.*;

public class Main {
    public static int[] fibo;
    public static int n;

    public int DFS(int n) {
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else {
            return fibo[n] = DFS(n - 2) + DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        fibo = new int[n + 1];
        m.DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}