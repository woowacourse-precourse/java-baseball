package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class BaseBallGame {
    public static final int COMPUTER_NUMBERS_SIZE = 3;
    public static final int COMPUTER_NUMBER_MIN = 1;
    public static final int COMPUTER_NUMBER_MAX = 9;

    GameMessageDisplay gameMessageDisplay;
    Validator inputValidator;
    List<Integer> computerNumbers;
    List<Integer> userNumbers;

    public BaseBallGame() {
        this.gameMessageDisplay = new GameMessageDisplay();
        this.inputValidator = new Validator();
        this.computerNumbers = new ArrayList<>();
        this.userNumbers = new ArrayList<>();
    }

    public void startGame() {
        this.gameMessageDisplay.printGameStartMessage();
        setComputerNumbers();
    }

    public void setComputerNumbers() {
        while (this.computerNumbers.size() < COMPUTER_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(COMPUTER_NUMBER_MIN, COMPUTER_NUMBER_MAX);
            if (!this.computerNumbers.contains(randomNumber)) {
                this.computerNumbers.add(randomNumber);
            }
        }
    }

    public void runGame() {
        String userInput = requestUserInput();

        if (isValidInput(userInput)) {
            setUserNumbers(userInput);
            printGameResult();
        }
    }

    public String requestUserInput() {
        this.gameMessageDisplay.printInputRequestMessage();
        String userInput = Console.readLine();
        return userInput;
    }

    public boolean isValidInput(String userInput) {
        return inputValidator.validateInput(userInput);
    }

    public void setUserNumbers(String userInput) {
        for (int index = 0; index < COMPUTER_NUMBERS_SIZE; index++) {
            int number = Character.getNumericValue(userInput.charAt(index));
            userNumbers.add(number);
        }
    }

    public void printGameResult() {
        Map<String, Integer> gameResult = getGameResult();
        this.gameMessageDisplay.printGameResultMessage(gameResult);
    }

    public Map<String, Integer> getGameResult() {
        Map<String, Integer> gameResult = new HashMap<>();
        int ballCount = 0;
        int strikeCount = 0;

        for (int index = 0; index < COMPUTER_NUMBERS_SIZE; index++) {
            if (userNumbers.get(index) == computerNumbers.get(index)) {
                strikeCount++;
                continue;
            }
            if (computerNumbers.contains(userNumbers.get(index))) {
                ballCount++;
            }
        }

        gameResult.put("ball", ballCount);
        gameResult.put("strike", strikeCount);
        return gameResult;
    }
}
