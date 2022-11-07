package baseball;

import camp.nextstep.edu.missionutils.Console;

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
        List<Integer> hitCount;
        List<Integer> secretNumber = createSecretNumber();
        do {
            hitCount = initHitCount();
            Integer totalNumber = inputTotalNumber();
            checkTotalNumberCount(totalNumber, secretNumber, hitCount);
            showHitCount(hitCount);
        } while(!checkWin(hitCount));
        System.out.println("3대의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static Integer inputTotalNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInputNumber = Console.readLine();
        checkUserInput(userInputNumber);
        return Integer.valueOf(userInputNumber);
    }


    private static boolean inputPlayGame() {
        return true;
    }

    private static List<Integer> checkOneDigitNumberCount(Integer number, Integer index, List<Integer> secretNumber, List<Integer> hitCount) {
        return new ArrayList<>();
    }


    private static void checkTotalNumberCount(Integer totalNumber, List<Integer> secretNumber, List<Integer> hitCount) {

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
