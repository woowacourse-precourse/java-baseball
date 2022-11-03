package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static class BaseballGameResult {
        int strike, ball;

        BaseballGameResult(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }

        void print() {
            if (strike == 3) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
                return;
            }

            StringBuilder ans = new StringBuilder();
            if (0 < ball) {
                ans.append(ball).append("ball ");
            }
            if (0 < strike) {
                ans.append(strike).append("스트라이크");
            }
            System.out.println(ans);
        }
    }

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

    static Boolean isBall(int computerIdx, String computer, boolean[] computerUsed,
                          int inputIdx, String input, boolean[] inputUsed) {
        if (computerUsed[computerIdx] || inputUsed[inputIdx]) {
            return false;
        }
        if (computer.charAt(computerIdx) != input.charAt(inputIdx)) {
            return false;
        }
        computerUsed[computerIdx] = inputUsed[inputIdx] = true;
        return true;
    }
    static int countBallExceptStrike(String computer, String input, List<Integer> strikeIndexes) {
        boolean[] computerUsed = new boolean[3];
        boolean[] inputUsed = new boolean[3];
        for (int idx : strikeIndexes) {
            computerUsed[idx] = true;
            inputUsed[idx] = true;
        }

        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ballCnt += isBall(i, computer, computerUsed, j, input, inputUsed)
                        .compareTo(false);
            }
        }
        return ballCnt;
    }

    static BaseballGameResult getGameResult(String computer, String input) {
        List<Integer> strikeIndexes = countStrike(computer, input);
        int ballCnt = countBallExceptStrike(computer, input, strikeIndexes);
        return new BaseballGameResult(strikeIndexes.size(), ballCnt);
    }

    public static void main(String[] args) {
        printGameStart();
    }
}
