package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        printStartGameSentence();
    }

    private static void printStartGameSentence() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> getComputerPick() {
        List<Integer> numbers = new ArrayList<>();
        int number;
        while (numbers.size() < 3) {
            number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }
}
