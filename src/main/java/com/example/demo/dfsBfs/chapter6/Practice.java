package com.example.demo.dfsBfs.chapter6;

import java.util.Scanner;

public class Practice {
    static int n, m;
    static int[] arr, ch, answer;

    public void DFS(int L) {
        if (L == m) {
            for (int x : answer) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    answer[L] = arr[i];
                    ch[i] = 1;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Practice T = new Practice();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        ch = new int[n];
        answer = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        T.DFS(0);
    }
}
