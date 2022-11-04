package baseball;

public class Application {
    public static void main(String[] args) {
        FlowHandler flowHandler = new FlowHandler();
        // TODO: 프로그램 구현
        while (true) {
            int restartValue = flowHandler.runGame();
            if (restartValue == 2) {
                break;
            }
        }
    }
}
