package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        printStartStatement();
        Score score;
        boolean playAgain = true;
        while (playAgain) {
            score = new Score();
            List<Integer> computerInputs = getRandomIntegers();
            while (!score.pass()) {
                List<Integer> userInputs = getIntegersThroughConsole();
                score = calculateScore(computerInputs, userInputs);
                printScore(score);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            playAgain = askIfUserPlaysGameAgain();
        }
    }

    private static void printStartStatement() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> getRandomIntegers() throws IllegalArgumentException {
        List<Integer> result = new ArrayList<>();
        Set<Integer> inputs = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int computerInput = Randoms.pickNumberInRange(1, 9);
            if (inputs.contains(computerInput)) {
                throw new IllegalArgumentException();
            }
            inputs.add(computerInput);
            result.add(computerInput);
        }
        return result;
    }

    private static List<Integer> getIntegersThroughConsole() throws IllegalArgumentException {
        List<Integer> result = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        int userInput = Integer.parseInt(Console.readLine());
        if (userInput < 100 || userInput > 999) {
            throw new IllegalArgumentException();
        }
        Set<Integer> digits = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int remainder = userInput % 10;
            if (digits.contains(remainder)) {
                throw new IllegalArgumentException();
            }
            digits.add(remainder);
            result.add(remainder);
            userInput /= 10;
        }
        Collections.reverse(result);
        return result;
    }

    private static boolean askIfUserPlaysGameAgain() throws NumberFormatException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInput = Integer.parseInt(Console.readLine());
        if (userInput == 1) {
            return true;
        } else if (userInput == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void printScore(Score result) {
        if (result.nothing == 3) {
            System.out.println("낫싱");
            return;
        }
        if (result.ball > 0) {
            System.out.printf("%d볼 ", result.ball);
        }
        if (result.strike > 0) {
            System.out.printf("%d스트라이크", result.strike);
        }
        System.out.println();
    }

    private static Score calculateScore
            (List<Integer> computerInputs, List<Integer> userInputs) {
        Score result = new Score();
        for (int i = 0; i < userInputs.size(); i++) {
            int userInput = userInputs.get(i);
            ScoreCategory subResult = calculateScoreWithOneInteger(computerInputs, userInput, i);
            if (subResult == ScoreCategory.STRIKE) {
                result.strike += 1;
            } else if (subResult == ScoreCategory.BALL) {
                result.ball += 1;
            } else if (subResult == ScoreCategory.NOTHING) {
                result.nothing += 1;
            }
        }
        return result;
    }

    private static ScoreCategory calculateScoreWithOneInteger
            (List<Integer> computerInputs, int userInput, int userInputIdx) {
        for (int i = 0; i < computerInputs.size(); i++) {
            int computerInput = computerInputs.get(i);
            if (computerInput == userInput && i == userInputIdx) {
                return ScoreCategory.STRIKE;
            } else if (computerInput == userInput) {
                return ScoreCategory.BALL;
            }
        }
        return ScoreCategory.NOTHING;
    }

    enum ScoreCategory {
        BALL, STRIKE, NOTHING
    }

    static class Score {
        int strike = 0;
        int ball = 0;
        int nothing = 0;

        public boolean pass() {
            return strike == 3;
        }
    }
}
