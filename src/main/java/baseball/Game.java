package baseball;

import camp.nextstep.edu.missionutils.Console;
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
        PrintComment.printInputComment();
        String userInput = Console.readLine();
        UserInputNumbers userInputNumbers = new UserInputNumbers(userInput);
        PrintComment.printUserInput(userInput);
        compareNumbers(userInputNumbers);
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

    public void compareNumbers(UserInputNumbers userInput) {
        gameState = new GameState();
        List<Integer> userInputValues = userInput.getUserInputNumbers();
        for (int idx=START_IDX; idx<NUMBER_LENGTH; idx++) {
            if (computer.get(idx)==userInputValues.get(idx)) {
                gameState.addStrike();
                continue;
            }
            if (computer.contains(userInputValues.get(idx))) {
                gameState.addBall();
            }
        }
        PrintComment.printGameState(gameState);
    }
}
