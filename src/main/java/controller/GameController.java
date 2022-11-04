package controller;

import domain.Game;

import java.util.Scanner;

public class GameController {
    Scanner scanner = new Scanner(System.in);
    private Game game;

    public GameController(){
        this.game = new Game();
    }

    public void startGame(){
        do{
            inputUserNumbers();
        }while(true);
    }

    private void inputUserNumbers(){
        String inputNumbers = scanner.next();
        game.setUserNumbers(inputNumbers);
    }
}
