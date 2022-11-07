package baseball.controller;

import baseball.exception.WrongContinueException;
import baseball.utill.StartGame;
import baseball.utill.Random;
import baseball.view.Input;
import baseball.view.Output;

public class BaseballController {
    public static void run() {
        runBaseBall();
        checkCountinue();
    }

    private static void runBaseBall() {
        int strikeCount = 0;
        int ballCount = 0;

        Random random = new Random();
        while(strikeCount != 3) {
            StartGame startGame = new StartGame(Input.startMessage());
            ballCount = startGame.calculateBallCount(random.randomNumbers());
            strikeCount = startGame.calculateStrikeCount(random.randomNumbers());
            Output.printResult(ballCount, strikeCount);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void checkCountinue() {
        String continueMessage = Input.askNextGame();

        if (continueMessage.equals("1")){
            runBaseBall();
            return;
        }

        if (continueMessage.equals("2")){
            System.out.println("게임 종료");
            return;
        }

        throw new WrongContinueException();
    }
}
