package com.example.demo.dfsBfs.chapter11;

import java.util.*;

class Pointer {
    int x, y;
    Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Practice {
    static int[][] board = new int[8][8];
    static int[][] answer = new int[8][8];
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public void BFS(int x, int y) {
        Queue<Pointer> q = new LinkedList<>();
        q.add(new Pointer(x, y));
        while (!q.isEmpty()) {
            Pointer tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.add(new Pointer(nx, ny));
                    answer[nx][ny] = answer[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Practice T = new Practice();
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        board[1][1] = 1;
        T.BFS(1, 1);
        if (answer[7][7] == 0) System.out.println(-1);
        else System.out.println(answer[7][7]);
    }
}
