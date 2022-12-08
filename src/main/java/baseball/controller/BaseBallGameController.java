package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.model.GameOverChecker;
import baseball.view.inputview.InputView;
import baseball.view.outview.OutView;
import java.util.List;

public class BaseBallGameController {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final InputView inputView = new InputView();
    private BaseBallGame baseBallGame = new BaseBallGame();


    public void start() {
        System.out.println(GAME_START);
        List<Integer> report = gameContinue();
        while (!isGameOver(report)) {
            report = gameContinue();
        }
        gameOverRequest();
    }

    private boolean isGameOver(List<Integer> report) {
        return GameOverChecker.check(report);
    }

    private List<Integer> gameContinue() {
        String ballNumbers = requestInput();
        return checkReport(ballNumbers);
    }

    private void gameOverRequest() {
        System.out.println(GAME_OVER);
        if (inputView.askNewGame()) {
            newGame();
        }
    }

    private void newGame() {
        baseBallGame = new BaseBallGame();
        start();
    }

    private List<Integer> checkReport(String ballNumbers) {
        List<Integer> report = baseBallGame.checkUserBallList(ballNumbers);
        OutView.print(report);
        return report;
    }

    public String requestInput() {
        return inputView.inputNumber();
    }
}
