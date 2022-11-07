package baseball;

public class GameSystem {
    public void startGame() {
        PickNumbers pickNumbers = new PickNumbers();
        UserInput userInput = new UserInput();
        pickNumbers.pickRandomNumbers();
        Decision.playing = true;
        while (Decision.playing) {
            userInput.numbers();
            Decision.call();
            if (!Decision.out) {
                continue;
            }
            userInput.reStartOrQuit();
            if (Decision.playing) {
                pickNumbers.pickRandomNumbers();
            }
        }
    }
}
