package baseball.view;

public class MessagePrinterImpl implements MessagePrinter{
    @Override
    public void printGameStart() {
        System.out.println(MessagesForPrint.GAME_START.getMessage());
    }

    @Override
    public void printReqGameNumbersInput() {
        System.out.printf(MessagesForPrint.INPUT_NUMBER.getMessage());
    }

    @Override
    public void printGameResult(String resultMessage) {
        System.out.println(resultMessage);
    }

    @Override
    public void printGameEnd() {
        System.out.println(MessagesForPrint.GAME_END.getMessage());
    }

    @Override
    public void printQuestionGameRestart() {
        System.out.println(MessagesForPrint.RESTART_GAME.getMessage());
    }
}
