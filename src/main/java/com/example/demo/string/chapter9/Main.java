package com.example.demo.string.chapter9;

import java.util.Scanner;

public class Main {

    public int solution(String str) {
        int answer = 0;
        String s = str.replaceAll("[^0-9]", "");
        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        System.out.println(T.solution(kb.next()));
    }
}
