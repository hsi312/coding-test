package com.example.demo;

import java.util.*;

public class Main {

    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for (int m = j + 1; m < n; m++) {
                    tSet.add(arr[i] + arr[j] + arr[m]);
                }
            }
        }
        int cnt = 0;
        for (int i : tSet) {
            cnt++;
            if (cnt == k) {
                return i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}