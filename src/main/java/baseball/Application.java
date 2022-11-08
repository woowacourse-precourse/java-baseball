package baseball;

import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        InputView inputView = new InputView();

        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            baseballGame.run();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } while (baseballGame.checkRetry(inputView.inputRetry()));
    }
}
