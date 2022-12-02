package baseball.controller;

import baseball.core.BaseballGame;
import baseball.exception.InputException;
import baseball.type.GameStatus;
import baseball.type.SuccessCondition;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Map;

import static baseball.type.GameStatus.*;

public class GameController {

    private BaseballGame baseballGame;
    private InputView inputView;
    private OutputView outputView;

    private GameController(BaseballGame baseballGame, InputView inputView, OutputView outputView) {
        this.baseballGame = baseballGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static GameController initGame() {
        return new GameController(BaseballGame.initBaseballGame(), new InputView(), new OutputView());
    }

    // 게임 시작부터 종료까지의 로직
    public void playGame() {
        outputView.printStart();
        GameStatus currentStatus = baseballGame.getCurrentStatus();
        while (currentStatus == START) {
            this.baseballGame.startGame();
            currentStatus = iterateGameLoop();
        }
    }

    // 플레이어가 정답을 맞출 때까지 실행됨
    private GameStatus iterateGameLoop() {
        GameStatus currentStatus = baseballGame.getCurrentStatus();
        while (currentStatus == ONGOING) {
            String inputNumber = inputView.readInputNumber();
            // TODO : validation 로직을 새로운 Validator 클래스에서 처리 예정
            InputException.validateInputNumber(inputNumber);
            Map<String, Integer> resultOfGameRound = baseballGame.executeGameRound(inputNumber);

            if (baseballGame.checkSuccessOrFail() == SuccessCondition.SUCCESS) {
                String gameCommand = inputView.readGameCommand();
                currentStatus = baseballGame.executeGameByCommand(gameCommand);
            } else {
                outputView.printBallAndStrike(resultOfGameRound.get("ball"), resultOfGameRound.get("strike"));
            }
        }
        return currentStatus;
    }
}
