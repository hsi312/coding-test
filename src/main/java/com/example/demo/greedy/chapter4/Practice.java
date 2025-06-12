package com.example.demo.greedy.chapter4;
/**
 6
 50 2
 20 1
 40 2
 60 3
 30 3
 30 1
 */

import java.util.*;

class Study implements Comparable<Study> {
    int money;
    int date;
    Study(int money, int date) {
        this.money = money;
        this.date = date;
    }
    @Override
    public int compareTo(Study o) {
        return o.date - this.date;
    }
}

public class Practice {
    static int n;
    static int lastDate = Integer.MIN_VALUE;
    static List<Study> arr = new ArrayList<>();

    public int solution() {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int j = 0;
        for (int i = lastDate; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).date < i) {
                    break;
                }
                pQ.add(arr.get(j).money);
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Practice p = new Practice();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int date = sc.nextInt();
            arr.add(new Study(money, date));
            if (lastDate < date) {
                lastDate = date;
            }
        }
        Collections.sort(arr);
        System.out.println(p.solution());
    }
}
