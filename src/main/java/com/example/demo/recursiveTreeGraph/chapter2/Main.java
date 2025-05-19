package com.example.demo.recursiveTreeGraph.chapter2;

public class Main {

    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n / 2);
            System.out.print(n % 2 + " ");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.DFS(11);
    }
}
