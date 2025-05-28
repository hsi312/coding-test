package com.example.demo.dfsBfs.chapter4;
/**

 */

import java.util.Scanner;

public class Main {
    static int[] answer;
    static int n, m;
    public void DFS(int L) {
        if (L == m) {
            for (int x : answer) System.out.print(x + " ");
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
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        answer = new int[m];
        T.DFS(0);
    }
}