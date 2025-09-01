package com.example.demo;

import java.util.*;

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static ArrayList<Point> home, pizza;
    static int[] combination;

    public void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h : home) {
                int dis = Integer.MAX_VALUE;
                for (int c : combination) {
                    dis = Math.min(dis, Math.abs(h.x - pizza.get(c).x) + Math.abs(h.y - pizza.get(c).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combination[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        home = new ArrayList<>();
        pizza = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    home.add(new Point(i, j));
                } else if (tmp == 2) {
                    pizza.add(new Point(i, j));
                }
            }
        }
        len = pizza.size();
        combination = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}