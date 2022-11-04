package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class Game {
    private static List<Integer> computer;

    public Game() {
        this.computer = pickThreeNumber();
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

    public GameState compareNumbers(String userInput) {
        UserInputNumbers userInputNumbers = new UserInputNumbers(userInput);
        List<Integer> userInputValues = userInputNumbers.getUserInputNumbers();
        GameState gameState = new GameState();

        for (int idx=START_IDX; idx<NUMBER_LENGTH; idx++) {
            if (computer.get(idx)==userInputValues.get(idx)) {
                gameState.addStrike();
                continue;
            }
            if (computer.contains(userInputValues.get(idx))) {
                gameState.addBall();
            }
        }
        return gameState;
    }
}
