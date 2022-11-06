package baseball;

import static baseball.Constant.*;

public class GameSystem {
    private boolean playing = true;

    public void startGame() {
        PickNumbers pickNumbers = new PickNumbers();
        UserInput userInput = new UserInput();
        pickNumbers.pickNumbers();
        while (playing) {
            userInput.inputNumbers();
            Decision.call();
            if (Decision.out) {
                //System.out.println("정답맞춤");
                if (userInput.chooseReStartOrQuit().equals(QUIT_GAME_INPUT)) {
                    break;
                }
                System.out.println("새게임 시작");
                pickNumbers.pickNumbers();
            }
        }
    }
}
