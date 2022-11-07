package baseball.controller;

import baseball.dto.Result;
import baseball.service.GameService;
import baseball.view.OutputView;

import static baseball.Const.*;

public class PlayGameController {

    private final GameService gameService;
    private final OutputView outputView;

    public PlayGameController(GameService gameService, OutputView outputView) {
        this.gameService = gameService;
        this.outputView = outputView;
    }

    public void run() {
        outputView.startGame(); //게임 시작문 출력
        Result strikeAndBall = gameService.checkStrikeAndBall(); //숫자 입력 후 볼, 스트라이크 횟수 체크
        outputView.result(strikeAndBall); //게임 결과 출력

        int strike = strikeAndBall.getStrike();
        String choiceRestartOrQuitGame = "";
        if (strike == THREE_STRIKE) { //3스트라이크 == 게임 종료문 출력 후 재시작, 종료 선택
            choiceRestartOrQuitGame = gameService.inputOneOrTwo();
            gameService.isNotRestartedAndQuitedGame(choiceRestartOrQuitGame);
        }
        if (strike != THREE_STRIKE) { //3스트라이크 아니면 다시 입력
            run();
        }
        if (choiceRestartOrQuitGame.equals(RESTART_GAME)) { //재시작 시 리스트에 있는 숫자 비우고 다시 시작, 아니면 종료
            gameService.clearRandomBallNumber();
            run();
        }
    }
}
