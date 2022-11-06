package baseball.controller;

import baseball.dto.Result;
import baseball.service.GameService;
import baseball.view.PrintGameResult;

import static baseball.Const.RESTART_GAME;
import static baseball.Const.THREE_STRIKE;

public class PlayGameController {

    private final GameService gameService;
    private final PrintGameResult printGameResult;

    public PlayGameController(GameService gameService, PrintGameResult printGameResult) {
        this.gameService = gameService;
        this.printGameResult = printGameResult;
    }

    public void run() {
        printGameResult.startGame(); //게임 시작문 출력
        Result strikeAndBall = gameService.checkStrikeAndBall(); //숫자 입력 후 볼, 스트라이크 횟수 체크
        printGameResult.result(strikeAndBall); //게임 결과 출력

        int strike = strikeAndBall.getStrike();
        if (strike == THREE_STRIKE) { //3스트라이크 = 게임 종료문 출력 후 재시작, 종료 선택
            String choiceRestartOrQuitGame = gameService.inputOneOrTwo();
            gameService.isNotRestartedAndQuitedGame(choiceRestartOrQuitGame);
            restartGame(gameService, choiceRestartOrQuitGame);
        }
        if (strike != THREE_STRIKE) { //3스트라이크 아니면 다시 시작
            run();
        }
    }

    private void restartGame(GameService gameService, String choiceRestartOrQuitGame) {
        if (choiceRestartOrQuitGame.equals(RESTART_GAME)) { //재시작 시 리스트에 있는 숫자 비우고 다시 시작
            gameService.clearRandomBallNumber();
            run();
        }
    }
}
