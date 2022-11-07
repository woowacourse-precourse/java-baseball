package baseball.Controller;

import baseball.Service.GameService;
import baseball.Service.GameServiceImpl;

public class GameController {

    private GameService gameService;

    public GameController(){
        this.gameService = new GameServiceImpl();
    }

    public void playGame(){
        while(this.gameService.playGame()){};
    }

}
