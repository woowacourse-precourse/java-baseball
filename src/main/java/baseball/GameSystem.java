package baseball;

public class GameSystem {
    public void startGame() {
        PickNumbers pickNumbers = new PickNumbers();
        UserInput userInput = new UserInput();
        pickNumbers.pickRandomNumbers();
        Decision.newGame();
        while (Decision.isPlaying()) {
            userInput.numbers();
            Decision.call();
            if (!Decision.out) {
                continue;
            }
            userInput.reStartOrQuit();
            if (Decision.isPlaying()) {
                pickNumbers.pickRandomNumbers();
            }
        }
    }
}
