package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class BaseBallGame {
    public static final int COMPUTER_NUMBERS_SIZE = 3;
    public static final int COMPUTER_NUMBER_MIN = 1;
    public static final int COMPUTER_NUMBER_MAX = 9;

    GameMessageDisplay gameMessageDisplay;
    UserInputter userInputter;
    List<Integer> computerNumbers;

    public BaseBallGame() {
        this.gameMessageDisplay = new GameMessageDisplay();
        this.computerNumbers = new ArrayList<>();
        this.userInputter = new UserInputter();
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
    }

    public void requestUserInput() {
        userInputter.readline();
    }
}
