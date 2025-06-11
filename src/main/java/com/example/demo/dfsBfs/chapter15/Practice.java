package com.example.demo.dfsBfs.chapter15;

import java.util.*;

class Pointer {
    int x, y;
    Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Practice {
    static int n, m, answer = Integer.MAX_VALUE;
    static List<Pointer> home = new ArrayList<>();
    static List<Pointer> pz = new ArrayList<>();
    static int[] combination;

    public void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Pointer h : home) {
                int nearPz = Integer.MAX_VALUE;
                for (int i : combination) {
                    nearPz = Math.min(nearPz, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += nearPz;
            }
            answer = Math.min(sum, answer);
        } else {
            for (int i = s; i < pz.size(); i++) {
                combination[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Practice p = new Practice();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    home.add(new Pointer(i, j));
                } else if (tmp == 2) {
                    pz.add(new Pointer(i, j));
                }
            }
        }
        combination = new int[m];
        p.DFS(0, 0);
        System.out.println(answer);
    }
}
