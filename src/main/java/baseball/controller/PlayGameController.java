package baseball.controller;

import baseball.dto.Result;
import baseball.service.GameService;
import baseball.view.OutputView;

import static baseball.Const.*;

/**
 * 프로그램 전체 흐름
 * 1. 게임 시작문 출력
 * 2. 숫자 입력 후 볼, 스트라이크 횟수 확인
 * 3. 게임 결과 출력
 * 4. 3스트라이크이면 게임 종료문 출력 후 재시작, 종료 선택 아니면 다시 숫자 입력
 * 5. 재시작 시 List에 있는 랜덤 숫자 비우고 다시 시작
 */
public class PlayGameController {

    private final GameService gameService;
    private final OutputView outputView;

    public PlayGameController(GameService gameService, OutputView outputView) {
        this.gameService = gameService;
        this.outputView = outputView;
    }

    public void run() {
        outputView.startGame();
        Result strikeAndBall = gameService.checkStrikeAndBall();
        outputView.result(strikeAndBall);

        int strike = strikeAndBall.getStrike();
        String choiceRestartOrQuitGame = "";
        if (strike == THREE_STRIKE) {
            choiceRestartOrQuitGame = gameService.inputOneOrTwo();
            gameService.isNotRestartedAndQuitedGame(choiceRestartOrQuitGame);
        }
        if (strike != THREE_STRIKE) {
            run();
        }
        if (choiceRestartOrQuitGame.equals(RESTART_GAME)) {
            gameService.clearRandomBallNumber();
            run();
        }
    }
}
