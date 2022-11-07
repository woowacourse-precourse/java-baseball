package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static boolean keepGaming = true;

    static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            playSmallGame();
            isKeepGaming();
        } while (keepGaming);
    }

    static boolean isKeepGaming() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endGame = Console.readLine();
        if (endGame.equals("1")) {
            keepGaming = true;
        } else if (endGame.equals("2")) {
            keepGaming = false;
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하여 프로그램을 종료합니다.");
        }
        return keepGaming;
    }

    static void playSmallGame() {
        generateNumber();
    }

    static List<Integer> generateNumber() {
        List<Integer> comNumbers = new ArrayList<>();
        do {
            int comNum = Randoms.pickNumberInRange(1, 9);
            if (!comNumbers.contains(comNum)) {
                comNumbers.add(comNum);
            }
        } while (comNumbers.size() < 3);
        return comNumbers;
    }
}
