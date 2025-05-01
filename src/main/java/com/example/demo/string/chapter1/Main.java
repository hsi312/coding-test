package com.example.demo.string.chapter1;

import java.util.Scanner;

public class Main {

    public int solution(String str, char t) {
        str = str.toLowerCase();
        t = Character.toLowerCase(t);
        int answer = 0;
        for (char c : str.toCharArray()) {
            if (c == t) {
                answer ++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);
        System.out.println(main.solution(str, c));
    }
}
