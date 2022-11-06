package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class BaseBallGame {
    public static final int COMPUTER_NUMBERS_SIZE = 3;
    public static final int COMPUTER_NUMBER_MIN = 1;
    public static final int COMPUTER_NUMBER_MAX = 9;

    GameMessageDisplay gameMessageDisplay;
    Validator inputValidator;
    List<Integer> computerNumbers;
    String userInput;

    public BaseBallGame() {
        this.gameMessageDisplay = new GameMessageDisplay();
        this.computerNumbers = new ArrayList<>();
        this.inputValidator = new Validator();
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
        requestUserInput();
        if (isValidInput()) {
            System.out.println("유효");
        }
    }

    public void requestUserInput() {
        this.gameMessageDisplay.printInputRequestMessage();
        this.userInput = Console.readLine();
    }

    public boolean isValidInput() {
        return inputValidator.validateInput(userInput);
    }
}
