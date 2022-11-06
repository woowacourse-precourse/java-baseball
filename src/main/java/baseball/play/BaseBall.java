package baseball;

import baseball.output.Guide;

public class BaseBall {

    public void start() {
        Guide.printStartingGuide();
        Game game = new Game();
        game.start();
    }

    private void printStartingGuide() {
        System.out.println("숫자 아구 게임을 시작합니다.");
    }

}
