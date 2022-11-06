package controller;

import domain.Game;
import domain.RoundResult;
import view.GameView;

import java.util.List;
import java.util.Scanner;

public class GameController {
    Scanner scanner = new Scanner(System.in);
    private Game game;

    public GameController(){
        this.game = new Game();
    }

    public void startGame(){
        game.createComputerNumbers();
        GameView.printStartMessage();
        do{
            GameView.printInputMessage();
            inputUserNumbers();
            RoundResult roundResult = game.getRoundResult();
            GameView.printRoundResultMessage(roundResult);
            if(roundResult.isWin()){
                GameView.printWinMessage();
                break;
            }
        }while(true);
    }

    private void inputUserNumbers(){
        String inputNumbers = scanner.next();
        game.setUserNumbers(inputNumbers);
    }
}
