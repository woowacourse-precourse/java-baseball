package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Command;
import domain.Game;
import domain.RoundResult;
import view.GameView;

public class GameController {
    private Game game;

    public GameController(){
        this.game = new Game();
    }

    public void startGame(){
        GameView.printStartMessage();
        do{
            game.createComputerNumbers();
            runRound();
            GameView.printEndMessage();
            Command userCommand = inputUserCommand();
            if(userCommand.isExit()){
                break;
            }
        }while(true);
    }

    private void runRound(){
        do{
            GameView.printInputMessage();
            game.setUserNumbers(inputUserNumbers());
            RoundResult roundResult = game.getRoundResult();
            GameView.printRoundResultMessage(roundResult);
            if(roundResult.isWin()){
                GameView.printWinMessage();
                break;
            }
        }while(true);
    }

    private String inputUserNumbers(){
        return Console.readLine();
    }

    public static Command inputUserCommand(){
        return new Command(Console.readLine());
    }
}
