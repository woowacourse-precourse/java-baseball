package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputAndOutput.printGameStartPhrase();
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.startGame();
    }
}