package baseball;

import baseball.domain.Computer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager(new Computer());

        gameManager.run();
    }
}
