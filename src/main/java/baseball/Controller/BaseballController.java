package baseball.Controller;


import baseball.Model.NumberItem;

import baseball.Service.impl.CompareServiceImpl;
import baseball.Service.impl.NumberServiceImpl;

import baseball.Service.interfaces.CompareService;
import baseball.Service.interfaces.NumberService;

import static baseball.Model.StatusItem.GAME_START;
import static baseball.Model.StatusItem.GAME_TERMINATE;
import static baseball.Model.StatusItem.GAME_RESTART;
import static baseball.Model.StatusItem.FIRST_COMPARE;
import static baseball.Model.StatusItem.THREE_STRIKE_CORRECT;

import static baseball.View.PrintInformationView.printRequestNumber;
import static baseball.View.PrintInformationView.printCorrectMessage;
import static baseball.View.PrintInformationView.printRestartMessage;
import static baseball.View.PrintInformationView.printGameStartMessage;

import camp.nextstep.edu.missionutils.Console;




public class BaseballController {

    private final NumberService numberService = new NumberServiceImpl();
    private final CompareService compareService = new CompareServiceImpl();
    private static NumberItem computerNumberItem = new NumberItem();
    private static NumberItem userNumberItem = new NumberItem();



    private static int gamePlayDecisionValue = GAME_START;

    public void gameStart () throws IllegalArgumentException{
        gamePlayDecisionValue = GAME_START;
        while(gamePlayDecisionValue == GAME_START || gamePlayDecisionValue == GAME_RESTART){
            gamePrepare();
            gamePlay();
        }


    }

    public void gamePrepare() throws IllegalArgumentException{
        printGameStartMessage();
        computerNumberItem = numberService.createComputerNumber();
    }

    public void gamePlay() throws IllegalArgumentException{
        int compareResultValue = FIRST_COMPARE;
        int gameRestartValue = GAME_START;
        while(compareResultValue != THREE_STRIKE_CORRECT && gameRestartValue != GAME_TERMINATE) {
            printRequestNumber();
            userNumberItem = numberService.createUserNumber();
            compareResultValue = compareService.compare(computerNumberItem, userNumberItem);
            if (compareResultValue == THREE_STRIKE_CORRECT) {
                printCorrectMessage();
                printRestartMessage();
                gameRestartValue = gameRestart();
                gamePlayDecisionValue = gameRestartValue;
            }
        }
    }

    public int gameRestart() throws IllegalArgumentException{
        int returnValue;
        String restart = Console.readLine();
        if (restart.equals("1")) {
            returnValue = GAME_RESTART;
        }
        else if (restart.equals("2")){
            returnValue = GAME_TERMINATE;
        }
        else {
            throw new IllegalArgumentException();
        }
        return returnValue;
    }

}
