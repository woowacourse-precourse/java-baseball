package baseball.game;

import baseball.input.FinishInput;
import baseball.input.GameInput;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final GameResultCalculator calculator;
    protected Number randomNumber;
    private GameInput playerInput;
    private State state;

    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_PROMPT = "숫자를 입력해주세요 : ";
    private final String PAUSE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final int BALL_IDX = 0;
    private final int STRIKE_IDX = 1;
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";

    public BaseballGame() {
        calculator = new GameResultCalculator();
    }


    public void start() {
        System.out.println(START_MESSAGE);

        state = State.START;
        generateRandomNumber();
    }

    public void play() {
        do {
            System.out.print(INPUT_PROMPT);
            readInput();
            List<Integer> result = calculateResult();
            printResult(result);
        } while (!calculator.isThreeStrike(randomNumber, playerInput.number));
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

    private void generateRandomNumber() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < 3) {
            addUniqueRandomDigit(digits);
        }
        randomNumber = new Number(digits);
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
        int ballCount = calculator.countBall(randomNumber, playerInput);
        int strikeCount = calculator.countStrike(randomNumber, playerInput);
        return List.of(ballCount, strikeCount);
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
