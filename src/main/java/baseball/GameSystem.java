package baseball;

public class GameSystem {
    public void startGame() {
        PickNumbers pickNumbers = new PickNumbers();
        UserInput userInput = new UserInput();
        pickNumbers.pickNumbers();
        Decision.playing = true;
        while (Decision.playing) {
            userInput.inputNumbers();
            Decision.call();
            if (!Decision.out) {
                continue;
            }
            userInput.chooseReStartOrQuit();
            if (Decision.playing) {
                pickNumbers.pickNumbers();
            }
        }
    }
}
