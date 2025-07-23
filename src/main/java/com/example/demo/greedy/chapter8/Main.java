package com.example.demo.greedy.chapter8;
/**
 7. 원더랜드(최소스패닝트리 pq)
 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
 원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
 아래의 그림은 그 한 예를 설명하는 그림이다.
 Image1.jpg
 위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.

 입력
 첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
 다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
 이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.

 출력
 모든 도시를 연결하면서 드는 최소비용을 출려한다.

 예시 입력 1
 9 12
 1 2 12
 1 9 25
 2 3 10
 2 8 17
 2 9 8
 3 4 18
 3 7 55
 4 5 44
 5 6 60
 5 7 38
 7 8 35
 8 9 15

 예시 출력 1
 196
 */

import java.util.*;

class Edge implements Comparable<Edge> {
    int vtx;
    int cost;
    public Edge(int vtx, int cost) {
        this.vtx = vtx;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Main {
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(a).add(new Edge(b, cost));
            graph.get(b).add(new Edge(a, cost));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int answer = 0;
        pq.add(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int vtx = tmp.vtx;
            int cost = tmp.cost;
            if (ch[vtx] == 0) {
                ch[vtx] = 1;
                answer += cost;
                for (Edge e : graph.get(vtx)) {
                    if (ch[e.vtx] == 0) {
                        pq.add(new Edge(e.vtx, e.cost));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
