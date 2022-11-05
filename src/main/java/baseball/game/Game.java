package baseball.game;

import baseball.input.GameInput;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public List<Integer> digits;
    private GameInput playerInput;

    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final int BALL_IDX = 0;
    private final int STRIKE_IDX = 1;

    public Game() {
        digits = new ArrayList<>();
        while (digits.size() < 3) {
            addUniqueRandomDigit();
        }
    }

    public void addUniqueRandomDigit() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!digits.contains(randomNumber)) {
            digits.add(randomNumber);
        }
    }

    public void start() {
        System.out.println(START_MESSAGE);
        List<Integer> result;
        do {
            readInput();
            result = calculateResult();
            printResult(result);
        } while (isCorrect(result));
        System.out.println(END_MESSAGE);
    }

    private void readInput() {
        String line = Console.readLine();
        int input = Integer.parseInt(line);
        playerInput = new GameInput(input);
    }

    private List<Integer> calculateResult() {
        // TODO
        return Collections.emptyList();
    }

    private void printResult(List<Integer> result) {
        // TODO
    }

    private boolean isCorrect(List<Integer> result) {
        // TODO
        return false;
    }

    private void end() {

    }
}
