package com.example.demo.greedy.chapter5;

import java.util.*;

class Vertex implements Comparable<Vertex> {
    int vtx;
    int cost;
    Vertex(int vtx, int cost) {
        this.vtx = vtx;
        this.cost = cost;
    }
    @Override
    public int compareTo(Vertex o) {
        return this.cost - o.cost;
    }
}
public class Practice {
    static int[] answer;
    static List<List<Vertex>> graph = new ArrayList<>();

    public void solution(int s) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(s, 0));
        while (!pq.isEmpty()) {
            Vertex tmp = pq.poll();
            int nowVtx = tmp.vtx;
            int nowCost = tmp.cost;
            for (Vertex c : graph.get(nowVtx)) {
                if (answer[c.vtx] > nowCost + c.cost) {
                    answer[c.vtx] = nowCost + c.cost;
                    pq.add(new Vertex(c.vtx, nowCost + c.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Practice p = new Practice();
        int n = sc.nextInt();
        int m = sc.nextInt();
        answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int root = sc.nextInt();
            int vtx = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(root).add(new Vertex(vtx, cost));
        }
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[0] = 0;
        p.solution(1);
        for (int i = 2; i <= n; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : Impossible");
            } else {
                System.out.println(i + " : " + answer[i]);
            }
        }
    }
}
