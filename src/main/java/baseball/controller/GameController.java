package baseball.controller;

import baseball.core.BaseballGame;
import baseball.exception.InputException;
import baseball.type.GameStatus;
import baseball.type.SuccessCondition;
import camp.nextstep.edu.missionutils.Console;

import static baseball.type.GameStatus.*;
import static baseball.display.OutputStatement.*;

public class GameController {

    private BaseballGame baseballGame;

    private GameController(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public static GameController initGame() {
        return new GameController(BaseballGame.initBaseballGame());
    }

    // 게임 시작부터 종료까지의 로직
    public void playGame() {

        // TODO : OutputView에서 처리 예정
        System.out.println(gameStart);
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
            //  TODO : InputView 로직으로 이전 예정
            System.out.print(enterNumber);
            String inputNumber = Console.readLine();
            InputException.validateInputNumber(inputNumber);
            baseballGame.executeGameRound(inputNumber);

            if (baseballGame.checkSuccessOrFail() == SuccessCondition.SUCCESS) {
                // TODO : InputView 로직으로 이전 예정
                System.out.println(correctNumber);
                String gameCommand = Console.readLine();
                currentStatus = baseballGame.executeGameByCommand(gameCommand);
            } else {
//                printBallAndStrike(numberOfBall, numberOfStrike);
            }
        }
        return currentStatus;
    }

    // TODO : OutputView로 이전 예정
    // 플레이어의 입력 숫자에 따라 볼과 스트라이크를 화면에 출력
    private void printBallAndStrike(Integer numberOfBall, Integer numberOfStrike) {
        if (numberOfBall == 0 && numberOfStrike == 0) {
            System.out.println(nothing);
        } else if (numberOfBall > 0 && numberOfStrike == 0) {
            System.out.println(numberOfBall + ball);
        } else if (numberOfBall == 0 && numberOfStrike > 0) {
            System.out.println(numberOfStrike + strike);
        } else {
            System.out.println(numberOfBall + ball + " " + numberOfStrike + strike);
        }
    }
}
