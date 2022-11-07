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
        inputNumber();
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

    static List<Integer> inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String userNum = Console.readLine();
        List<Integer> userNumbers = new ArrayList<>();
        if (userNumbers.size() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 프로그램을 종료합니다.");
        }
        for (int i = 0; i < 3; i++) {
            int digit = Integer.parseInt(userNum.substring(i, i + 1));
            userNumbers.add(digit);
        }
        return userNumbers;
    }
}
