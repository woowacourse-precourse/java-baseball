package ui;

import java.util.List;

public class ConsoleOutput implements Output{

    @Override
    public void printMessage(String message) {
        System.out.print(message);
    }
    @Override
    public void printStartMessage() {
        printMessage(Messages.START_GAME.getMessage());
    }
    @Override
    public void printRequestNumberInput() {
        printMessage(Messages.REQUEST_NUMBER_INPUT.getMessage());
    }
    @Override
    public void printEndGame() {
        printMessage(Messages.END_GAME.getMessage());
    }
    @Override
    public void printRequestRestartGameInput() {
        printMessage(Messages.REQUEST_RESTART_GAME_INPUT.getMessage());
    }
    @Override
    public void printGameResult(String buffer) {
        printMessage(buffer+"\n");
    }
}
