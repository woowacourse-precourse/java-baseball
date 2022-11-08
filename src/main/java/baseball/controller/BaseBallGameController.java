package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.utils.Constants;
import baseball.utils.validators.UserInputValidator;
import baseball.view.BaseBallGameView;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGameController {

    private BaseballGameService gameService;

    public BaseBallGameController(){
        this.gameService = new BaseballGameService();
        printWelcomeMessage();
    }

    public void run(){
        playGame();
        endGame();
        askRetryGame();
    }

    private void printWelcomeMessage(){
        BaseBallGameView.printStartGame();
    }

    private void playGame(){
        gameService.initGame();
        gameService.playGame();
    }

    private void endGame(){
        BaseBallGameView.printAskRetry();
    }

    private void askRetryGame(){
        if(getRetryInput() == Constants.BASEBALL_GAME_RETRY){
            run();
        }
    }

    private int getRetryInput() throws IllegalArgumentException{
        String retry = Console.readLine();

        UserInputValidator.validateRetryInput(retry);

        return Integer.parseInt(retry);
    }
}
