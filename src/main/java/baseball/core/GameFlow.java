package baseball.core;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

import static baseball.core.GameStatus.*;
import static baseball.display.OutputStatement.*;

public class GameFlow {

    // 게임 시작부터 종료까지의 로직
    public static GameStatus playGame(BaseballGame baseballGame) {

        System.out.println(gameStart);
        GameStatus currentStatus = ONGOING;
        baseballGame.setCurrentStatus(currentStatus);
        currentStatus = executeGame(baseballGame);
        baseballGame.setCurrentStatus(currentStatus);
        return currentStatus;
    }

    // 플레이어가 정답을 맞출 때까지 실행됨
    private static GameStatus executeGame(BaseballGame baseballGame) {
        GameStatus currentStatus = baseballGame.getCurrentStatus();
        String targetNumber = baseballGame.getTargetNumber();
        while (currentStatus == ONGOING) {
            System.out.print(enterNumber);
            String inputNumber = Console.readLine();
            InputException.validateInputNumber(inputNumber);
            Integer numberOfBall = baseballGame.countTheNumberOfBall(targetNumber, inputNumber);
            Integer numberOfStrike = baseballGame.countTheNumberOfStrike(targetNumber, inputNumber);

            if (numberOfStrike == 3) {
                System.out.println(correctNumber);
                String selectGameStatus = Console.readLine();
                InputException.validateInputNumber(inputNumber);
                currentStatus = changeGameStatus(currentStatus, selectGameStatus);
            } else {
                printBallAndStrike(numberOfBall, numberOfStrike);
            }
        }
        return currentStatus;
    }

    // 플레이어가 정답을 맞춘 후에 1을 입력하면 재시작, 2를 입력하면 게임 완전히 종료
    private static GameStatus changeGameStatus(GameStatus currentStatus, String selectGameStatus) {
        if (selectGameStatus.equals("1")) currentStatus = START;
        if (selectGameStatus.equals("2")) currentStatus = QUIT;
        return currentStatus;
    }

    // 플레이어의 입력 숫자에 따라 볼과 스트라이크를 화면에 출력
    private static void printBallAndStrike(Integer numberOfBall, Integer numberOfStrike) {
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
