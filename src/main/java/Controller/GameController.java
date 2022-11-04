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
        if(re_user_input() == RETRY){
            run();
        }
    }

    public int re_user_input() throws IllegalArgumentException{
        int user_num = Integer.parseInt(Console.readLine());

        if(user_num < 0 || user_num > EXIT){
            throw new IllegalArgumentException();
        }

        return user_num;
    }
}
