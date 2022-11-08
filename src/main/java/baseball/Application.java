package baseball;
public class Application {
    public static void main(String[] args) {
        PlayBaseBallGame playBaseBall = new PlayBaseBallGame();
        InputNumber number = new InputNumber();

        while (true) {
            playBaseBall.playGame();
            number.inputReStartNumber();
            if (number.reStartNumber.equals("2")) {
                break;
            }
        }

    }

}
