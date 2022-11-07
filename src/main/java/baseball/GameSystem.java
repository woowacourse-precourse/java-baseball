package baseball;

public class GameSystem {
    public void startGame() {
        Computer computer = new Computer();
        UserInput userInput = new UserInput();
        computer.pickRandomNumbers();
        Decision.newGame();
        while (Decision.isPlaying()) {
            userInput.numbers();
            Decision.call();
            if (!Decision.out) {
                continue;
            }
            userInput.reStartOrQuit();
            if (Decision.isPlaying()) {
                computer.pickRandomNumbers();
            }
        }
    }
}
