package baseball.view;

public class MessagePrinterImpl implements MessagePrinter{
    @Override
    public void printGameStart() {
        System.out.println(PrintEnum.GameStart.getMessage());
    }

    @Override
    public void printReqGameNumbersInput() {

    }

    @Override
    public void printGameResult() {

    }

    @Override
    public void printGameEnd() {

    }

    @Override
    public void printQuestionGameRestart() {

    }
}
