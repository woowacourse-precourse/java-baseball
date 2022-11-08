package baseball;

import static baseball.Command.RESTART;
import static baseball.Command.EXIT;

import java.util.List;

public class BaseballGame {

    private final Computer computer;
    private final User user;
    private Command command;

    public BaseballGame() {
        computer = new Computer();
        user = new User();
        command = null;
    }

    public void startGame() {
        printStartMessage();
        boolean onGame = true;

        while (onGame) {
            runComputer(getUserInput());
            if (isCorrectAnswer()) {
                command = getUserCommand();
            }
            if (isRestart()) {
                computer.setRandomNumber();
                command = null;
            }
            if (isExit()) {
                onGame = false;
            }
            clearScore();
        }
    }

    private List<Integer> getUserInput() {
        user.receiveThreeNumber();
        List<Integer> userInput = user.getInputNumber();
        user.resetUserNumber();
        return userInput;
    }

    private void runComputer(List<Integer> userInput) {
        computer.calculateScore(userInput);
        computer.printResult();
    }

    private Command getUserCommand() {
        user.receiveOneNumber();
        List<Integer> userCommand = user.getInputNumber();
        user.resetUserNumber();
        return computer.getCommand(userCommand);
    }

    private void clearScore() {
        computer.clearScore();
    }

    private void printStartMessage() {
        System.out.println(Message.GAME_START_MESSAGE);
    }

    private boolean isCorrectAnswer() {
        return computer.isCorrectAnswer();
    }

    private boolean isRestart() {
        return command != null && command.equals(RESTART);
    }

    private boolean isExit() {
        return command != null && command.equals(EXIT);
    }
}
