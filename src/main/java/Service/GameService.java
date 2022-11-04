package Service;

import camp.nextstep.edu.missionutils.Console;
import domain.Game;
import domain.RandomNumber;
import domain.UserNumber;
import domain.UserValidate;
import view.SystemMessage;

public class GameService {
    private static final int NUM_SIZE = 3;

    RandomNumber randomNumber = new RandomNumber();
    UserNumber userNumber = new UserNumber();
    UserValidate userValidate = new UserValidate();
    Game game;
    SystemMessage systemMessage;

    public void set_game(){
        game = new Game(randomNumber.getNumbers());
    }

    public void play_game(){
        int strike = 0;
        while(strike != 3){
            game.initialize();
            userNumber.setUser_numbers(userNumber.getUser_numbers());
            // 계산
            systemMessage.game_score_message(game.getBall_count(), game.getStrike_count());
            strike = game.getStrike_count();
        }
    }

    public void calculate(int[] userNumbers, int[] randomNumbers){
        for (int r = 0; r < randomNumbers.length; r++) {
            for (int u = 0; u < userNumbers.length; u++) {
                if(randomNumbers[r] == userNumbers[u]){
                    increase_cnt(r, u);
                }
            }
        }
    }

    public void increase_cnt(int r, int u){
        if(r == u){
            game.increase_strike();
        }
        if(r != u){
            game.increase_ball();
        }
    }
}
