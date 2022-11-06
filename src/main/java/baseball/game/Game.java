package baseball.game;

import baseball.input.FinishInput;
import baseball.input.GameInput;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    protected Number randomNumber;
    private GameInput playerInput;
    private State state;

    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String PAUSE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final int BALL_IDX = 0;
    private final int STRIKE_IDX = 1;
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";

    public Game() {
    }


    public void start() {
        System.out.println(START_MESSAGE);

        state = State.START;
        generateRandomNumber();
    }

    public void play() {
        List<Integer> result;
        do {
            readInput();
            result = calculateResult();
            printResult(result);
        } while (!isCorrect(result));
    }

    public void pause() {
        System.out.println(PAUSE_MESSAGE);
        state = State.PAUSE;

        if (readFinishInput() == FinishInput.QUIT_GAME) {
            end();
        }
    }

    public boolean isEnd() {
        return state == State.END;
    }


    private boolean isCorrect(List<Integer> result) {
        int strikeCount = result.get(STRIKE_IDX);
        return strikeCount == 3;
    }

    private void generateRandomNumber() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < 3) {
            addUniqueRandomDigit(digits);
        }
        randomNumber = new Number(digits.get(0), digits.get(1), digits.get(2));
    }


    private void addUniqueRandomDigit(List<Integer> digits) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!digits.contains(randomNumber)) {
            digits.add(randomNumber);
        }
    }

    private void readInput() {
        String line = Console.readLine();
        int input = Integer.parseInt(line);
        playerInput = new GameInput(input);
    }

    private List<Integer> calculateResult() {
        int ballCount = countBall();
        int strikeCount = countStrike();
        return List.of(ballCount, strikeCount);
    }

    private int countStrike() {
        int count = 0;
        if (randomNumber.first == playerInput.number.first) {
            count++;
        }
        if (randomNumber.second == playerInput.number.second) {
            count++;
        }
        if (randomNumber.third == playerInput.number.third) {
            count++;
        }
        return count;
    }

    private int countBall() {
        int count = 0;

        int firstInput = playerInput.number.first;
        int secondInput = playerInput.number.second;
        int thirdInput = playerInput.number.third;

        boolean isFirstBall = firstInput != randomNumber.first && randomNumber.hasDigit(firstInput),
                isSecondBall = secondInput != randomNumber.second && randomNumber.hasDigit(secondInput),
                isThirdBall = thirdInput != randomNumber.third && randomNumber.hasDigit(thirdInput);

        if (isFirstBall) {
            count++;
        }
        if (isSecondBall) {
            count++;
        }
        if (isThirdBall) {
            count++;
        }

        return count;
    }

    private void printResult(List<Integer> result) {
        int ballCount = result.get(BALL_IDX);
        int strikeCount = result.get(STRIKE_IDX);
        StringBuilder resultStr = new StringBuilder();
        if (ballCount != 0) {
            resultStr.append(ballCount);
            resultStr.append(BALL + " ");
        }
        if (strikeCount != 0) {
            resultStr.append(strikeCount);
            resultStr.append(STRIKE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            resultStr.append(NOTHING);
        }
        System.out.println(resultStr);
    }


    private FinishInput readFinishInput() {
        int inputNumber = Integer.parseInt(Console.readLine());
        return FinishInput.numberOf(inputNumber);
    }

    private void end() {
        state = State.END;
        System.out.println(END_MESSAGE);
    }
}
