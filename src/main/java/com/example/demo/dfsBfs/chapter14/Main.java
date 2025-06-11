package com.example.demo.dfsBfs.chapter14;
/**
 13. 섬나라 아일랜드
 N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 Image1.jpg
 만약 위와 같다면 섬의 개수는 5개입니다.

 입력
 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
 두 번째 줄부터 격자판 정보가 주어진다.

 출력
 첫 번째 줄에 섬의 개수를 출력한다.

 예시 입력 1
 7
 1 1 0 0 0 1 0
 0 1 1 0 1 1 0
 0 1 0 0 0 0 0
 0 0 0 1 0 1 1
 1 1 0 1 1 0 0
 1 0 0 0 1 0 0
 1 0 1 0 1 0 0

 예시 출력 1
 5
 */

import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0;
    static int n;
    static Queue<Point> q = new LinkedList<>();

    public void BFS(int x, int y) {
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    q.add(new Point(nx, ny));
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    T.BFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }
}