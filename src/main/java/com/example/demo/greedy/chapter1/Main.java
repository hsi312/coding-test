package com.example.demo.greedy.chapter1;
/**
 1. 씨름 선수
 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
 현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
 “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
 N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.

 입력
 첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.
 두 번째 줄부터 N명의 흰돌 능력치와 검은돌 능력치 정보가 차례로 주어집니다.
 각 선수의 흰돌능력치가 모두 다르고, 검은돌 능력치도 모두 다릅니다. 능력치 값은 1,000,000이하의 자연수입니다.

 출력
 첫째 줄에 바둑 선수로 뽑히는 최대 인원을 출력하세요.

 예시 입력 1
 5
 172 67
 183 65
 180 70
 170 72
 181 60

 예시 출력 1
 3

 힌트
 출력설명
 (183, 65), (180, 70), (170, 72) 가 선발됩니다.
 (181, 60)은 (183, 65)보다 키와 몸무게 모두 낮기 때문에 탈락이고, (172, 67)은 (180, 70) 때문에 탈락입니다.
 */

import java.util.*;

class Body implements Comparable<Body> {
    int h, w;
    Body(int h, int w) {
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Body o) {
        return o.w - this.w;
    }
}

public class Main {

    public int solution(List<Body> arr) {
        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for (Body b : arr) {
            if (b.h > max) {
                max = b.h;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        List<Body> arr = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h, w));
        }
        Collections.sort(arr);
        System.out.println(T.solution(arr));
    }
}
