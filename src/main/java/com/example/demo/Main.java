package com.example.demo;

import java.util.*;

class Node {
    int data;
    Node lt;
    Node rt;
    public Node(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}
public class Main {
    Node root;
    public int BFS(int L, Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.lt == null && cur.rt == null) {
                    return L;
                }
                if(cur.lt != null) {
                    q.offer(cur.lt);
                }
                if(cur.rt != null) {
                    q.offer(cur.rt);
                }
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.root = new Node(1);
        m.root.lt = new Node(2);
        m.root.rt = new Node(3);
        m.root.lt.lt = new Node(4);
        m.root.lt.rt = new Node(5);
        m.root.rt.lt = new Node(6);
        m.root.rt.rt = new Node(7);
        m.root.rt.lt.lt = new Node(8);
        System.out.println(m.BFS(0, m.root));
    }
}