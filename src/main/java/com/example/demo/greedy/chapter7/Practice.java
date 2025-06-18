package com.example.demo.greedy.chapter7;

import java.util.*;

class Vertex implements Comparable<Vertex> {
    int a;
    int b;
    int cost;
    Vertex(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
    @Override
    public int compareTo(Vertex o) {
        return this.cost = o.cost;
    }
}
public class Practice {
    static int[] unf;
    static List<Vertex> arr = new ArrayList<>();

    public static int Find(int v) {
        if (v == unf[v]) {
            return unf[v];
        } else {
            return unf[v] = Find(unf[v]);
        }
    }
    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            arr.add(new Vertex(a, b, cost));
        }
        Collections.sort(arr);

    }
}
