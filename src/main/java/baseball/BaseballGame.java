package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String START_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Number computer;
    private Number user;
    private int ball;
    private int strike;
    private boolean isCorrect;
    private boolean isExit;

    public BaseballGame() {
    }

    public void run() {
        System.out.println(GAME_START);

        while (!isExit) {
            initialize();

            computer = new Number();
            computer.setRandomNumber();
            System.out.println("computer = " + computer.getDigits());

            while (!isCorrect) {
                user = new Number();
                user.inputNumber();

                compareNumbers();
                String result = makeResultString();
                System.out.println(result);
            }

            System.out.println(GAME_END);
            System.out.println(START_AGAIN);
            startAgain();
        }
    }

    private void initialize() {
        isCorrect = false;
        isExit = false;
    }

    private void compareNumbers() {
        List<Integer> computerValue = computer.getDigits();
        List<Integer> userValue = user.getDigits();
        countBall(computerValue, userValue);
        countStrike(computerValue, userValue);
        ball -= strike;
    }

    private void countBall(List<Integer> computerValue, List<Integer> userValue) {
        ball = 0;
        for (int i = 0; i < 3; i++) {
            Integer target = userValue.get(i);
            if (computerValue.contains(target)) {
                ball += 1;
            }
        }
    }

    private void countStrike(List<Integer> computerValue, List<Integer> userValue) {
        strike = 0;
        for (int i = 0; i < 3; i++) {
            Integer computerNumber = computerValue.get(i);
            Integer userNumber = userValue.get(i);
            if (computerNumber.equals(userNumber)) {
                strike += 1;
            }
        }
    }

    private String makeResultString() {
        String answer = NOTHING;
        if (strike == 3) {
            isCorrect = true;
            answer = String.format("%d%s", strike, STRIKE);
        } else if (ball > 0 & strike > 0) {
            answer = String.format("%d%s %d%s", ball, BALL, strike, STRIKE);
        } else if (ball > 0) {
            answer = String.format("%d%s", ball, BALL);
        } else if (strike > 0) {
            answer = String.format("%d%s", strike, STRIKE);
        }
        return answer;
    }

    private void startAgain() {
        String input = Console.readLine();
        if (input.equals("2")) {
            isExit = true;
        } else if (!input.equals("1")) {
            throw new IllegalArgumentException();
        }
    }
}
