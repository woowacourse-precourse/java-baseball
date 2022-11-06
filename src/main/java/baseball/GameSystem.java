package baseball;

public class GameSystem {
    public void startGame() {
        PickNumbers pickNumbers = new PickNumbers();
        UserInput userInput = new UserInput();
        pickNumbers.pickNumbers();
        while (Decision.playing) {
            userInput.inputNumbers();
            Decision.call();

            if (Decision.out) {
                userInput.chooseReStartOrQuit();
            }
        }
    }
}
