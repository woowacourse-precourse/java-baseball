package baseball.controller;

import baseball.exception.WrongContinueException;
import baseball.message.Messages;

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
        System.out.println(Messages.GAME_CLEAR);
    }

    private static void checkCountinue() {
        String continueMessage = Input.askNextGame();

        if (continueMessage.equals("1")){
            runBaseBall();
            return;
        }

        if (continueMessage.equals("2")){
            System.out.println(Messages.END_GAME);
            return;
        }

        throw new WrongContinueException();
    }
}
