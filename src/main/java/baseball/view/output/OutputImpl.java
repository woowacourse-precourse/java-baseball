package baseball.view.output;


import baseball.utils.OutputMessage;

public class OutputImpl implements Output {

    @Override
    public void printStartMessage() {
        System.out.println(OutputMessage.START_MESSAGE);
    }

    @Override
    public void printNumberRequest() {
        System.out.print(OutputMessage.NUMBER_REQUEST_MESSAGE);
    }

    @Override
    public void printResult(String resultMessage) {
        System.out.println(resultMessage);
    }

    @Override
    public void printSuccessMessage() {
        System.out.println(OutputMessage.SUCCESS_MESSAGE);
    }

    @Override
    public void printEndMessage() {
        System.out.println(OutputMessage.END_MESSAGE);
    }
}
