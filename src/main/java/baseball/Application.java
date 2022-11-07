package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ThreeNumberRepository threeNumberRepository = new ThreeNumberRepository();
        NumberBaseballGameController numberBaseballGame = new NumberBaseballGameController(threeNumberRepository);
        numberBaseballGame.startGame();
    }
}
