package com.example.demo;

import java.util.*;

public class Main {
    static int n, answer;
    static int[][] board;
    int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public void DFS(int x, int y) {
        if (board[x][y] == 1) {
            board[x][y] = 0;
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                }
                T.DFS(i, j);
            }
        }
        System.out.println(answer);
    }
}