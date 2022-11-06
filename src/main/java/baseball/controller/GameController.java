package baseball.controller;

import baseball.model.Game;

public class GameController{
    Game game;

    public GameController(Game game){
        this.game = game;
    }

    public void run(){
        game.startGame();
        int questionNumber = game.UserAsk();
        String judge = game.judgeTheUser(questionNumber);;

        while(!game.endGame(judge)){
            questionNumber = game.UserAsk();
            judge = game.judgeTheUser(questionNumber);
        }

        if(game.askUserToRestart()){
            game = new Game();
            run();
        }
    }
}
