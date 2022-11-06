package baseball;

import static baseball.Constant.*;

public class GameSystem {
    public void startGame() {
        PickNumbers pickNumbers = new PickNumbers();
        UserInput userInput = new UserInput();
        pickNumbers.pickNumbers();
        while (true) {
            userInput.inputNumbers();
            Decision.call();
            if (Decision.out) {
                if (userInput.chooseReStartOrQuit().equals(QUIT_GAME_INPUT)) {
                    break;
                }
                System.out.println("새게임 시작");
                pickNumbers.pickNumbers();
                Decision.reset();
            }
        }
    }
}
