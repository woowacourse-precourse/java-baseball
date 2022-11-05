package baseball;

public class Game {
    private ComputerRandomNumber computerRandomNumber;
    private UserInput userInput;

    public Game() {
        computerRandomNumber = new ComputerRandomNumber();
        userInput = new UserInput();
    }

    public void run() {
        computerRandomNumber.makeComputerNumber();
        userInput.userNumberInput();
    }
}
