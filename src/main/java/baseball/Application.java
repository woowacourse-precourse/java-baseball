package baseball;
public class Application {

    public static void main(String[] args) {
        PlayBaseBallGame playBaseBall = new PlayBaseBallGame();
        InputNumber number = new InputNumber();
        Exception exception = new Exception();

        while(true) {
            playBaseBall.playGame();
            number.inputReStartNumber();
            exception.checkReStarException(number.reStartNumber);
            if (number.reStartNumber.equals("2")) {
                break;
            }
        }

    }

}
