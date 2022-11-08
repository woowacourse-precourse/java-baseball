package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class BaseBallGame {
    public static final int COMPUTER_NUMBERS_SIZE = 3;
    public static final int COMPUTER_NUMBER_MIN = 1;
    public static final int COMPUTER_NUMBER_MAX = 9;
    public static final int REGAME = 1;
    public static final int STOP = 2;

    GameMessageDisplay gameMessageDisplay;
    Validator inputValidator;
    List<Integer> computerNumbers;
    List<Integer> userNumbers;
    boolean success;

    public BaseBallGame() {
        this.gameMessageDisplay = new GameMessageDisplay();
        this.inputValidator = new Validator();
        this.computerNumbers = new ArrayList<>();
        this.userNumbers = new ArrayList<>();
        this.success = false;
    }

    public void runGame() {
        printGameStart();
        do {
            prepareGame();
            guessComputerNumbersUntilSuccess();
        } while (askStopOrRegame() == REGAME);
    }

    public void printGameStart() {
        this.gameMessageDisplay.printGameStartMessage();
    }

    public void prepareGame() {
        this.success = false;
        setComputerNumbers();
    }

    public void setComputerNumbers() {
        computerNumbers.clear();
        while (this.computerNumbers.size() < COMPUTER_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(COMPUTER_NUMBER_MIN, COMPUTER_NUMBER_MAX);
            if (!this.computerNumbers.contains(randomNumber)) {
                this.computerNumbers.add(randomNumber);
            }
        }
    }

    public void guessComputerNumbersUntilSuccess() {
        while (!this.success) {
            String userInput = getUserInput();
            if (isValidInput(userInput)) {
                setUserNumbers(userInput);
                printGameResult();
            }
        }
    }

    public String getUserInput() {
        printInputRequest();
        String userInput = Console.readLine();
        return userInput;
    }

    public void printInputRequest() {
        this.gameMessageDisplay.printInputRequestMessage();
    }

    public boolean isValidInput(String userInput) {
        return inputValidator.validateInput(userInput);
    }

    public void setUserNumbers(String userInput) {
        userNumbers.clear();
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

        if (isSuccess(gameResult)) {
            this.success = true;
        }

        return gameResult;
    }

    public boolean isSuccess(Map<String, Integer> gameResult) {
        int strikeCount = gameResult.get("strike");
        if (strikeCount == COMPUTER_NUMBERS_SIZE) {
            return true;
        }
        return false;
    }

    public int askStopOrRegame() {
        this.gameMessageDisplay.printStopOrRegameRequestMessage();
        String userChoice = Console.readLine();
        int stopOrRegame = STOP;

        if (isValidChoice(userChoice)) {
            stopOrRegame = Integer.parseInt(userChoice);
        }

        return stopOrRegame;
    }

    public boolean isValidChoice(String userChoice) {
        return this.inputValidator.validateChoice(userChoice);
    }
}
