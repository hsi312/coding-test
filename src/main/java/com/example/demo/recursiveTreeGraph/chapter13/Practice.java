package com.example.demo.recursiveTreeGraph.chapter13;
/**
 레벨 탐색
 */

import java.util.*;

public class Practice {
    static int n, m;
    static int[] ch, dis;
    static ArrayList<ArrayList<Integer>> graph;

    public void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                dis[cur] = L;
                for (int nv : graph.get(cur)) {
                    if (ch[nv] == 0) {
                        ch[nv] = 1;
                        q.add(nv);
                    }
                }
            }
            L++;
        }
    }

    public static void main(String[] args) {
        Practice T = new Practice();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        ch = new int[n + 1];
        dis = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
