package com.example.demo.stackQueue.chapter3;

import java.util.*;

public class Main {

    public int solution(int n, int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int column : moves) {
            for (int row = 0; row < n; row++) {
                int col = column - 1;
                int tmp = board[row][col];
                board[row][col] = 0;
                if (tmp == 0) {
                    continue;
                }
                if (!stack.isEmpty() && stack.peek() == tmp) {
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(tmp);
                }
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T  = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, board, moves));
    }
}