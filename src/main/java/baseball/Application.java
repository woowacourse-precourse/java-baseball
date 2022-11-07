package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        while (true) {
            playGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String more = Console.readLine();

            if (more.equals("1")) {
                continue;
            } else if (more.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException("종료를 위해서는 2를 입력해야 합니다.");
            }
        }
    }

    public static Integer[] generateAnswer() {
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            int generated = Randoms.pickNumberInRange(1, 9);
            if (answerList.contains(generated)) {
                continue;
            }
            answerList.add(generated);
        }
        return answerList.toArray(Integer[]::new);
    }


    public static Integer[] userInputToIntegerArray(String userInput) throws IllegalArgumentException {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력값이 3자리가 이닙니다.");
        }

        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) > '9' || userInput.charAt(i) < '1') {
                throw new IllegalArgumentException("입력값이 1~9 사이의 숫자가 아닙니다.");
            }
        }

        Integer[] result = {0, 0, 0};
        for (int i = 0; i < 3; i++) {
            result[i] = userInput.charAt(i) - '0';
        }
        return result;
    }

    public static int countStrike(Integer[] realAnswer, Integer[] userAnswer) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (realAnswer[i].equals(userAnswer[i])) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int countBall(Integer[] realAnswer, Integer[] userAnswer, int strike) {
        int cnt = 0;
        Set answerSet = new HashSet(Arrays.asList(realAnswer));
        for (int i = 0; i < 3; i++) {
            if (answerSet.contains(userAnswer[i])) {
                cnt++;
            }
        }
        return cnt - strike;
    }

    public static void printBallCount(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
    }

    public static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int strike = 0;
        int ball;
        Integer[] answer = generateAnswer();
        while (strike != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String strUserAns = Console.readLine();

            Integer[] arrUserAns = userInputToIntegerArray(strUserAns);

            strike = countStrike(answer, arrUserAns);
            ball = countBall(answer, arrUserAns, strike);

            printBallCount(strike, ball);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
