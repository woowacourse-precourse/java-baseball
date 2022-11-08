package baseball.view;

public interface MessagePrinter {

    void printGameStart();
    void printReqGameNumbersInput();
    void printGameResult(String message);
    void printGameEnd();
    void printQuestionGameRestart();
}
