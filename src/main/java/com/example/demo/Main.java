package com.example.demo;

import java.util.*;

class Pointer {
    public int x;
    public int y;
    Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int m, n, day = Integer.MIN_VALUE;
    static int[][] graph, dist;
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    static Queue<Pointer> q = new LinkedList<>();

    public void BFS() {
        while (!q.isEmpty()) {
            Pointer cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 0) {
                    graph[nx][ny] = 1;
                    q.offer(new Pointer(nx, ny));
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        graph = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                graph[i][j] = num;
                if (num == 1) {
                    q.offer(new Pointer(i, j));
                }
            }
        }
        T.BFS();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    flag = true;
                }
                day = Math.max(day, dist[i][j]);
            }
        }
        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }
}