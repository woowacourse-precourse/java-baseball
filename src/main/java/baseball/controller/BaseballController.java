package baseball.controller;

import baseball.exception.WrongContinueException;
import baseball.utill.Random;
import baseball.view.Input;

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

        }
    }

    private static void checkCountinue() {
        String continueMessage = Input.askNextGame();

        if (continueMessage.equals(1)){
            runBaseBall();
            return;
        }

        if (continueMessage.equals(2)){
            return;
        }

        throw new WrongContinueException();
    }
}
