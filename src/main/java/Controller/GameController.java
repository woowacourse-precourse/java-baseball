package Controller;

import Service.GameService;
import camp.nextstep.edu.missionutils.Console;
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

    private void startGame(){
        gameService.set_game();
    }

    private void playGame(){
        gameService.play_game();
    }

    private void endGame(){
        SystemMessage.end_game_message();
    }

    private void askContinue(){
        RequestUser.request_retry();
        if(re_user_input() == RETRY){
            run();
        }
    }

    private int re_user_input() throws IllegalArgumentException{
        int user_num = Integer.parseInt(Console.readLine());

        if(user_num < 0 || user_num > EXIT){
            throw new IllegalArgumentException();
        }

        return user_num;
    }
}
