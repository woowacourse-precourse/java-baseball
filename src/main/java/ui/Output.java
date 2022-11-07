package ui;

public interface Output {
    void printMessage(String message);

    void printStartMessage();

    void printRequestNumberInput();

    void printEndGame();

    void printRequestRestartGameInput();

    void printGameResult(String buffer);
}
