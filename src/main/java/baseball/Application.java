package baseball;

public class Application {
    public static void main(String[] args) {
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        // TODO: 프로그램 구현
        numberBaseballGame.gameStart();
        while (true) {
            numberBaseballGame.inputNumber();
            numberBaseballGame.countGameResults();
            numberBaseballGame.printGameResult();
        }
    }
}