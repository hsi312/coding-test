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
    static int[][] graph, dist;
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public int BFS(int L) {
        Queue<Pointer> q = new LinkedList<>();
        q.offer(new Pointer(1, 1));

        while (!q.isEmpty()) {
            Pointer cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx == 7 && ny == 7) return dist[cur.x][cur.y] + 1;
                if (nx >= 0 && nx <= 7 && ny >= 0 && ny <= 7 && graph[nx][ny] == 0) {
                    graph[nx][ny] = 1;
                    q.offer(new Pointer(nx, ny));
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        graph = new int[8][8];
        dist = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        graph[1][1] = 1;
        System.out.println(T.BFS(0));
    }
}