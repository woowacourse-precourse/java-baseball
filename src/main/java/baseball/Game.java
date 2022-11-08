package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class Game {
    private static List<Integer> computer;
    private GameState gameState;

    public Game() {
        this.computer = pickThreeNumber();
    }

    public void start() {
        System.out.print(INPUT_COMMENT);
        compareNumbers(InputNumbers.getInputNumbers());
    }

    public boolean isAnswer() {
        if (gameState.getStrike() == ANSWER_COUNT) {
            System.out.println(CORRECT_COMMENT);
            return true;
        }
        return false;
    }

    public boolean canRestart() {
        System.out.println(RESTART_COMMENT);
        if (InputNumbers.getControlNumber().equals(END)) {
            return false;
        }
        return true;
    }

    public static List<Integer> pickThreeNumber() {
        List<Integer> threeNumber = new ArrayList<>();
        while (threeNumber.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!threeNumber.contains(randomNumber)) {
                threeNumber.add(randomNumber);
            }
        }
        return threeNumber;
    }

    public void compareNumbers(List<Integer> userInput) {
        gameState = new GameState();
        for (int idx = INITIAL_NUMBER; idx < NUMBER_LENGTH; idx++) {
            if (computer.get(idx) == userInput.get(idx)) {
                gameState.addStrike();
                continue;
            }
            if (computer.contains(userInput.get(idx))) {
                gameState.addBall();
            }
        }
        gameState.printGameState();
    }
}
