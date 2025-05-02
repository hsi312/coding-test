package com.example.demo.hashMapTreeSet.chapter4;
/**
 S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

 입력
 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

 출력
 S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

 예시 입력 1
 bacaAacba
 abc

 예시 출력 1
 3
 */

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> tm = new HashMap<>();
        HashMap<Character, Integer> sm = new HashMap<>();
        for (char c : t.toCharArray()) {
            tm.put(c, tm.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length() - 1; i++) {
            sm.put(s.charAt(i), sm.getOrDefault(s.charAt(i), 0) + 1);
        }
        int lt = 0;
        for(int rt = t.length() - 1; rt < s.length(); rt++) {
            sm.put(s.charAt(rt), sm.getOrDefault(s.charAt(rt), 0) + 1);
            if (sm.equals(tm)) answer++;
            sm.put(s.charAt(lt), sm.get(s.charAt(lt)) - 1);
            if (sm.get(s.charAt(lt)) == 0) sm.remove(s.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        String t = kb.next();
        System.out.println(T.solution(s, t));
    }
}
