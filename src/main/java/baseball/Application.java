package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static String inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return readLine();
    }
    static void checkInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        boolean[] used = new boolean[10];
        used[0] = true;
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) || used[ch - '0']) {
                throw new IllegalArgumentException();
            }
            used[ch - '0'] = true;
        }
    }

    static String pickRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        List<String> stringNumbers = numbers.stream().map(String::valueOf).collect(Collectors.toList());
        return String.join("", stringNumbers);
    }

    static List<Integer> countStrike(String computer, String input) {
        List<Integer> strikeIndexes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (computer.charAt(i) == input.charAt(i)) {
                strikeIndexes.add(i);
            }
        }
        return strikeIndexes;
    }

    public static void main(String[] args) {
        printGameStart();
    }
}
