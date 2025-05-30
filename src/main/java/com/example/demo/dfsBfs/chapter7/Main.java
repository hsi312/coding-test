package com.example.demo.dfsBfs.chapter7;
/**
 7. 조합의 경우수(메모이제이션)
 하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.

 입력
 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.

 출력
 첫째 줄에 조합수를 출력합니다.

 예시 입력 1
 5 3

 예시 출력 1
 10

 예시 입력 2
 33 19

 예시 출력 2
 818809200
 */

import java.util.Scanner;

public class Main {
    static int[][] arr;
    public int DFS(int n, int r) {
        if (arr[n][r] != 0) return arr[n][r];
        if (r == 0 || n == r) {
            return 1;
        } else {
            return arr[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        arr = new int[n + 1][r + 1];
        System.out.println(T.DFS(n, r));
    }
}