package com.example.demo;

import java.util.*;

public class Main {

    public int BFS(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int[] ch = new int[10001];
        int[] dis = {1, -1, 5};
        int L = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int j : dis) {
                    int tmp = cur + j;
                    if (tmp == e) {
                        return L + 1;
                    }
                    if (tmp >= 1 && tmp <= 10000 && ch[tmp] == 0) {
                        ch[tmp] = 1;
                        q.offer(tmp);
                    }
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(m.BFS(s, e));
    }
}