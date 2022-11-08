package baseball.baseballgame.Controller;

import baseball.baseballgame.BaseBallGame;
import baseball.baseballgame.GameOverChecker;
import baseball.inputview.InputView;
import baseball.outview.OutView;
import java.util.List;

public class BaseBallGameController {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void start() {
        BaseBallGame baseBallGame = new BaseBallGame();
        System.out.println(GAME_START);
        InputView inputView = new InputView();
        String ballNumbers = inputView.inputNumber();
        List<Integer> report = baseBallGame.checkUserBallList(ballNumbers);
        OutView.print(report);
        boolean flag = GameOverChecker.check(report);
        while (!flag) {
            ballNumbers = inputView.inputNumber();
            report = baseBallGame.checkUserBallList(ballNumbers);
            OutView.print(report);
            flag = GameOverChecker.check(report);
        }
        System.out.println(GAME_OVER);
        if (inputView.ask_restart()) {
            start();
        }
    }
}
