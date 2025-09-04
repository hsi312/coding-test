package com.example.demo;

import java.util.*;

class Time implements Comparable<Time>{
    int start;
    char state;
    Time(int start, char state) {
        this.start = start;
        this.state = state;
    }
    @Override
    public int compareTo(Time o) {
        if (this.start == o.start) {
            return this.state - o.state;
        } else {
            return this.start - o.start;
        }
    }
}

public class Main {

    public int solution(ArrayList<Time> arr) {
        int cnt = 0;
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        for (Time t : arr) {
            if (t.state == 'b') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Time(sc.nextInt(), 'b'));
            arr.add(new Time(sc.nextInt(), 'a'));
        }
        System.out.println(T.solution(arr));
    }
}