package Service;

import camp.nextstep.edu.missionutils.Console;
import domain.Game;
import domain.RandomNumber;
import domain.UserNumber;
import domain.UserValidate;

public class GameService {
    private static final int NUM_SIZE = 3;

    RandomNumber randomNumber = new RandomNumber();
    UserNumber userNumber = new UserNumber();
    UserValidate userValidate = new UserValidate();
    Game game;

    public void set_game(){
        game = new Game(randomNumber.getNumbers());
    }

    public void start_game(){

    }
}
