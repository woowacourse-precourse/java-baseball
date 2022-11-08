package Service;

import camp.nextstep.edu.missionutils.Console;
import domain.Game;
import domain.RandomNumber;
import domain.UserNumber;
import domain.UserValidate;
import view.RequestUser;
import view.SystemMessage;

public class GameService {
    private static final int NUM_SIZE = 3;

    RandomNumber randomNumber = new RandomNumber();
    UserNumber userNumber = new UserNumber();
    UserValidate userValidate = new UserValidate();
    Game game;
    SystemMessage systemMessage = new SystemMessage();

    public void set_game(){
        randomNumber.setRandomNumber();
        game = new Game(randomNumber.getNumbers());
    }

    public void play_game(){
        systemMessage.game_start();
        int strike = 0;
        while(strike != 3){
            play();
            systemMessage.game_score_message(game.getBall_count(), game.getStrike_count());
            strike = game.getStrike_count();
        }
    }

    public void play(){
        game.initialize();
        userNumber.setUser_numbers(getUserNumber());
        score_calculate(userNumber.getUser_numbers(), game.getGame_numbers());
    }

    private int[] getUserNumber() throws IllegalArgumentException {
        RequestUser.request_input();
        String user_input = Console.readLine();
        return userValidate.validate_user_input(user_input);
    }

    private void calculate(int[] userNumbers, int[] randomNumbers, int index){
        int tmp = -1;

        for (int r = 0; r < randomNumbers.length; r++) {
            if(randomNumbers[r] == userNumbers[index]){
                tmp = r;
                break;
            }
        }
        increase_cnt(index, tmp);
    }

    private void score_calculate(int[] userNumbers, int[] randomNumbers){
        for (int i = 0; i < NUM_SIZE; i++) {
            calculate(userNumbers, randomNumbers, i);
        }
    }

    private void increase_cnt(int index, int tmp){
        if(index == tmp){
            game.increase_strike();
        }
        if(index != tmp && tmp != -1){
            game.increase_ball();
        }
    }
}
