package baseball.view;

public class MessagePrinterImpl implements MessagePrinter{
    @Override
    public void printGameStart() {
        System.out.println(PrintEnum.GAMESTART.getMessage());
    }

    @Override
    public void printReqGameNumbersInput() {
        System.out.printf(PrintEnum.INPUTNUMBER.getMessage());
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
