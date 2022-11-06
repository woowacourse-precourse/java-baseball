package baseball.view.output;


public class OutputImpl implements Output {

    @Override
    public void printMessage(String resultMessage) {
        System.out.println(resultMessage);
    }
}
