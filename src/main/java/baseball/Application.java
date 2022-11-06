package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    class DataBase {
        private List<Integer> answer = new ArrayList<>();
        private List<Integer> userInput = new ArrayList<>();
        private int strike = 0;
        private int ball = 0;
        private int nothing = 0;
    }
}

