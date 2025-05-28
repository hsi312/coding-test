package com.example.demo.dfsBfs.chapter3;
/**
 3. 최대점수 구하기(DFS)
 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)

 입력
 첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.

 출력
 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.

 예시 입력 1
 5 20
 10 5
 25 12
 15 8
 6 3
 7 4

 예시 출력 1
 41
 */

import java.util.Scanner;

public class Main {
    static int answer = Integer.MIN_VALUE, n, m;
    public void DFS(int L, int sum, int time, int[] arr, int[] timeArr) {
        if (time > m) return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L], time + timeArr[L], arr, timeArr);
            DFS(L + 1, sum, time, arr, timeArr);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        int[] arr1 = new int[n];
        int[] timeArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
            timeArr[i] = kb.nextInt();
        }
        T.DFS(0, 0, 0, arr1, timeArr);
        System.out.println(answer);
    }
}