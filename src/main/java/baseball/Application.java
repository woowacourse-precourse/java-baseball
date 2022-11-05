package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다!!!");
        System.out.println(answer(args));

    }

    public static ArrayList<Integer> answer(String[] args) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            answer.add((int)(Math.random() * 9 + 1));
        }
        return answer;
    }
}

