package com.example.demo.greedy.chapter5;
/**
 다익스트라 알고리즘
 아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로
 그램을 작성하세요. (경로가 없으면 Impossible를 출력한다)
 2 5
 1 2 5
 12
 5
 4 5 2
 5
 3 4 6
 5
 ▣ 입력설명
 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
 결정보와 거리비용이 주어진다.
 ▣ 출력설명
 1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.
 ▣ 입력예제 1
 6 9
 1 2 12
 1 3 4
 2 1 2
 2 3 5
 2 5 5
 3 4 5
 4 2 2
 4 5 5
 6 4 5
 // 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.
 ▣ 출력예제 1
 2 : 11
 3 : 4
 4 : 9
 5 : 14
 6 : impossible
 */

import java.util.*;

class Edge implements Comparable<Edge> {
    int vtx;
    int cost;
    Edge(int vtx, int cost) {
        this.vtx = vtx;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Main {
    static int[] answer;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public void solution(int a) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(a, 0));
        answer[a] = 0;
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int nowVtx = tmp.vtx;
            int nowCost = tmp.cost;
            if (nowCost > answer[nowVtx]) {
                continue;
            }
            for (Edge eg : graph.get(nowVtx)) {
                if (answer[eg.vtx] > nowCost + eg.cost) {
                    answer[eg.vtx] = nowCost + eg.cost;
                    pq.add(new Edge(eg.vtx, nowCost + eg.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int root = sc.nextInt();
            int vtx = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(root).add(new Edge(vtx, cost));
        }
        answer = new int[n + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        T.solution(1);
        for (int i = 2; i <= n; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : Impossible");
            } else {
                System.out.println(i + " : " + answer[i]);
            }
        }
    }
}
