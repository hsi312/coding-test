package com.example.demo.recursiveTreeGraph.chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice {
    static int n, m, answer = 0;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    public void DFS(int v) {
        if (n == v) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Practice T = new Practice();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        ch = new int[n + 1];
        graph = new ArrayList<>();
        for ( int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
