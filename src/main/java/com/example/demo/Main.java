package com.example.demo;

import java.util.*;

public class Main {

    public String solution(String a, String b) {
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            mapA.put(arr1[i], mapA.getOrDefault(arr1[i], 0) + 1);
            mapB.put(arr2[i], mapB.getOrDefault(arr2[i], 0) + 1);
        }
        for (char c : mapA.keySet()) {
            if (!mapA.get(c).equals(mapB.get(c))) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        System.out.println(T.solution(a, b));
    }
}