package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GET_NUMBER = "숫자를 입력해주세요 : ";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String START_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private List<Integer> computer;
    private List<Integer> user;
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
            makeRandomNumber();
            System.out.println("computer = " + computer);

            while (!isCorrect) {
                System.out.print(GET_NUMBER);
                getUserNumber();

                compareNumbers();
                String result = makeResultString();
                System.out.println(result);
            }

            System.out.println(START_AGAIN);
            startAgain();
        }
    }

    private void initialize() {
        isCorrect = false;
        isExit = false;
    }

    private void makeRandomNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private void getUserNumber() {
        String input = Console.readLine();
        user = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (i == 3) {
                throw new IllegalArgumentException();
            }

            char c = input.charAt(i);
            int number = Character.getNumericValue(c);
            if (!isValidateNumber(number)) {
                throw new IllegalArgumentException();
            }
            user.add(number);
        }
    }

    private boolean isValidateNumber(int number) {
        return number != 0 & !user.contains(number);
    }

    private void compareNumbers() {
        countBall();
        countStrike();
        ball -= strike;
    }

    private void countBall() {
        ball = 0;
        for (int i = 0; i < 3; i++) {
            Integer target = user.get(i);
            if (computer.contains(target)) {
                ball += 1;
            }
        }
    }

    private void countStrike() {
        strike = 0;
        for (int i = 0; i < 3; i++) {
            Integer computerNumber = computer.get(i);
            Integer userNumber = user.get(i);
            if (computerNumber.equals(userNumber)) {
                strike += 1;
            }
        }
    }

    private String makeResultString() {
        String answer = NOTHING;
        if (strike == 3) {
            isCorrect = true;
            answer = String.format("%d%s\n%s", strike, STRIKE, GAME_END);
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
