package baseball;

import java.util.List;

public class Application {

    static List<Integer> startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return makeThreeNumber();

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        startMessage();



    }
}