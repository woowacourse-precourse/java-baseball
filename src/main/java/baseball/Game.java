package baseball;

public class Game {
    private ComputerRandomNumber computerRandomNumber;
    private UserInput userInput;

    private UserInputToList userInputToList;

    public Game() {
        computerRandomNumber = new ComputerRandomNumber();
        userInput = new UserInput();
        userInputToList = new UserInputToList();
    }

    public void run() {
        computerRandomNumber.makeComputerNumber();
        userInputToList.userNumList(userInput.userNumberInput());
        userInputToList.getUserNum();
    }
}
