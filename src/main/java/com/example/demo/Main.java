package com.example.demo;

import java.util.*;

public class Main {

    public int solution(int n, int[][] board, int m, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for (int col : moves) {
            for (int row = 1; row < n; row++) {
                if (board[row][col] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[row][col]) {
                        stack.pop();
                        cnt += 2;
                        board[row][col] = 0;
                        break;
                    }
                    stack.push(board[row][col]);
                    board[row][col] = 0;
                    break;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 1;
        int[][] board = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, board, m, moves));
    }
}