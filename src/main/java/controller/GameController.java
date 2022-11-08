package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.BaseballNumbers;
import domain.Command;
import domain.RoundResult;
import view.GameView;

public class GameController {
    private BaseballNumbers computerNumbers;

    public GameController(){}

    public void startGame(){
        GameView.printStartMessage();
        do{
            createComputerNumbers();
            runRound();
            GameView.printEndMessage();
        }while(Command.findByValue(Console.readLine()) == Command.RESTART);
    }

    private void runRound(){
        RoundResult roundResult = null;
        do{
            GameView.printInputMessage();
            roundResult = computerNumbers.compareTo(inputUserNumbers());
            GameView.printRoundResultMessage(roundResult);
        }while(!roundResult.isWin());
        GameView.printWinMessage();
    }

    private void createComputerNumbers(){
        this.computerNumbers = BaseballNumbers.getComputerNumbers();
    }

    private BaseballNumbers inputUserNumbers(){
        return BaseballNumbers.getUserNumbers(Console.readLine());
    }
}
