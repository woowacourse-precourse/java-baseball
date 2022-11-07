package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            play();
        } while (inputPlayGame());
    }

    private static void play() {

    }

    private static Integer inputTotalNumber() {
        return 1;
    }


    private static boolean inputPlayGame() {
        return true;
    }

    private static List<Integer> checkOneDigitNumberCount(Integer number, Integer index, List<Integer> secretNumber, List<Integer> hitCount) {
        return new ArrayList<>();
    }


    private static List<Integer> checkTotalNumberCount(Integer totalNumber, List<Integer> secretNumber) {
        return new ArrayList<>();
    }

    private static List<Integer> initHitCount() {
        return new ArrayList<>();
    }

    private static void showHitCount(List<Integer> hitCount) {

    }

    private static boolean checkWin(List<Integer> hitCount) {
        return true;
    }

    private static List<Integer> createSecretNumber() {
        return new ArrayList<>();
    }

}
