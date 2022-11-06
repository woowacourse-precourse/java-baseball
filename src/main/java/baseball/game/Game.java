package baseball.game;

import baseball.input.FinishInput;
import baseball.input.GameInput;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Integer> digits;
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

    private void generateDigits() {
        digits = new ArrayList<>();
        while (digits.size() < 3) {
            addUniqueRandomDigit();
        }
    }

    public boolean isEnd() {
        return state == State.END;
    }

    public void addUniqueRandomDigit() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!digits.contains(randomNumber)) {
            digits.add(randomNumber);
        }
    }

    public void play() {
        List<Integer> result;
        do {
            readInput();
            result = calculateResult();
            printResult(result);
        } while (!isCorrect(result));
    }

    public void start() {
        System.out.println(START_MESSAGE);

        state = State.START;
        generateDigits();
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
        if (digits.get(0) == playerInput.first) {
            count++;
        }
        if (digits.get(1) == playerInput.second) {
            count++;
        }
        if (digits.get(2) == playerInput.third) {
            count++;
        }
        return count;
    }

    private int countBall() {
        int count = 0;
        int first = digits.get(0);
        int second = digits.get(1);
        int third = digits.get(2);

        if (playerInput.first == second || playerInput.first == third) {
            count++;
        }
        if (playerInput.second == first || playerInput.second == third) {
            count++;
        }
        if (playerInput.third == first || playerInput.third == second) {
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

    private boolean isCorrect(List<Integer> result) {
        return result.get(1) == 3;
    }

    public void pause() {
        System.out.println(PAUSE_MESSAGE);
        state = State.PAUSE;

        if (readFinishInput() == FinishInput.QUIT_GAME) {
            end();
        }
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
