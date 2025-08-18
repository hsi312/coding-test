package com.example.demo;

import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] dis;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;

    public void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nv : graph.get(cur)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    dis[nv] = dis[cur] + 1;
                    q.add(nv);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dis = new int[n + 1];
        ch = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i +  " : " + dis[i]);
        }
    }
}