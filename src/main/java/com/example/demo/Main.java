package com.example.demo;

import java.util.*;

class Lecture implements Comparable<Lecture> {
    int money;
    int date;

    Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.date - this.date;
    }
}

public class Main {
    public static int n, max = Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int answer = 0;
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).date < i) {
                    break;
                }
                pq.offer(arr.get(j).money);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int date = sc.nextInt();
            arr.add(new Lecture(money, date));
            if (max < date) {
                max = date;
            }
        }

        System.out.println(T.solution(arr));
    }
}