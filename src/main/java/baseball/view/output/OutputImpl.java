package baseball.view.output;


public class OutputImpl implements Output {

    private final String START_MESSAGE = "숫자 야구를 시작합니다.";

    @Override
    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
}
