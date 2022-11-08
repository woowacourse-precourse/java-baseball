package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class BaseBallGame {
    public static final int COMPUTER_NUMBERS_SIZE = 3;
    public static final int COMPUTER_NUMBER_MIN = 1;
    public static final int COMPUTER_NUMBER_MAX = 9;
    public static final String STRIKE = "strike";
    public static final String BALL = "ball";
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
            if (!isValidInput(userInput)) {
                String errorMessage = this.inputValidator.getErrorMessage();
                throw new IllegalArgumentException(errorMessage);
            }
            setUserNumbers(userInput);
            printGameResult();
        }
    }

    public String getUserInput() {
        printInputRequest();
        String userInput = readLine();
        return userInput;
    }

    public void printInputRequest() {
        this.gameMessageDisplay.printInputRequestMessage();
    }

    public String readLine() {
        return Console.readLine();
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

        countBallAndStrike(gameResult);

        if (isSuccess(gameResult)) {
            this.success = true;
        }

        return gameResult;
    }

    public void countBallAndStrike(Map<String, Integer> gameResult) {
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

        putCountResult(gameResult, ballCount, strikeCount);
    }

    public void putCountResult(Map<String, Integer> gameResult, int ballCount, int strikeCount) {
        gameResult.put(BALL, ballCount);
        gameResult.put(STRIKE, strikeCount);
    }

    public boolean isSuccess(Map<String, Integer> gameResult) {
        int strikeCount = gameResult.get(STRIKE);
        if (strikeCount == COMPUTER_NUMBERS_SIZE) {
            return true;
        }
        return false;
    }

    public int askStopOrRegame() {
        String userChoice = getUserChoice();
        int stopOrRegame = Integer.parseInt(userChoice);

        if (!isValidChoice(userChoice)) {
            String errorMessage = this.inputValidator.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }

        return stopOrRegame;
    }

    public String getUserChoice() {
        printStopOrRegameRequest();
        String userChoice = readLine();
        return userChoice;
    }

    public void printStopOrRegameRequest() {
        this.gameMessageDisplay.printStopOrRegameRequestMessage();
    }

    public boolean isValidChoice(String userChoice) {
        return this.inputValidator.validateChoice(userChoice);
    }
}
