package com.example.demo;

import java.util.*;

class Time implements Comparable<Time>{
    int start;
    int end;
    Time(int h, int w) {
        this.start = h;
        this.end = w;
    }
    @Override
    public int compareTo(Time o) {
        if (end == o.end) {
            return this.start - o.start;
        } else {
            return this.end - o.end;
        }
    }
}

public class Main {

    public int solution(ArrayList<Time> arr) {
        int cnt = 0;
        int endTime = 0;
        Collections.sort(arr);
        for (Time t : arr) {
            if (t.start >= endTime) {
                endTime = t.end;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Time(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(T.solution(arr));
    }
}