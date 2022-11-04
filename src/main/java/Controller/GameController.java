package Controller;

import Service.GameService;
import view.RequestUser;
import view.SystemMessage;

public class GameController {
    private final int NUM_SIZE = 3;
    private final int RETRY = 1;
    private final int EXIT = 2;

    GameService gameService = new GameService();

    public void run(){
        startGame();
        playGame();
        endGame();
        askContinue();
    }

    public void startGame(){
        gameService.set_game();
    }

    public void playGame(){
        gameService.play_game();
    }

    public void endGame(){
        SystemMessage.end_game_message();
    }

    public void askContinue(){
        RequestUser.request_retry();
        if(Userinput == RETRY){
            run();
        }
    }
}
