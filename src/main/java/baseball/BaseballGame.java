package baseball;

import java.util.List;


public class BaseballGame {

    private static final boolean end = false;
    private final GameService gameService = new GameService();

    public void gameStart(){

        List<Integer> randomNumber = Number.getRandomNumber();

        while(!end){
            List<Integer> userNumber = Number.inputUserNumber();

            Integer strike = gameService.countStrike(randomNumber, userNumber);
            Integer ball = gameService.countBall(randomNumber, userNumber);
        }
    }
}
