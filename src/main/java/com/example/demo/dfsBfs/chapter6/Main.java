package com.example.demo.dfsBfs.chapter6;
/**
 순열 구하기
 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합
 니다.
 ▣ 입력설명
 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
 ▣ 출력설명
 첫 번째 줄에 결과를 출력합니다.
 출력순서는 사전순으로 오름차순으로 출력합니다.
 ▣ 입력예제 1
 3 2
 3 6 9
 ▣ 출력예제 1
 3 6
 3 9
 6 3
 6 9
 9 3
 9 6
 */

import java.util.*;

public class Main {
    static int n, m;
    static int[] answer, arr, ch;
    public void DFS(int L) {
        if (L == m) {
            for (int x : answer) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    answer[L] = arr[i];
                    ch[i] = 1;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        answer = new int[m];
        ch = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        T.DFS(0);
    }
}