package baseball;

import Util.RamdomNumber;
import static Constant.Const.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    int[] answer;
    Hint hint;
    User user;
    RamdomNumber randomNumber;
    BaseballGame(){
        this.hint = new Hint();
        this.answer = new int[NUMBER_LENGTH];
        this.user = new User();
        this.randomNumber = new RamdomNumber(NUMBER_LENGTH);
    }

    public void startGame(){
        System.out.println(GAME_START);
        answer = randomNumber.makeRandomNumber(NUMBER_LENGTH);
        do {
            hint.getHint(user.UserInput(), answer);
        } while (hint.strike != 3);
    }
    public boolean doneGame(){
        System.out.println(GAME_DONE);
        return restartGame();
    }

    private boolean restartGame(){
        System.out.println(GAME_RESTART);
        int input = Integer.parseInt(readLine());
        if (input == RESTART){
            return true;
        } else if (input == EXIT){
            return false;
        } else {
            throw new IllegalArgumentException(INPUT_WRONG);
        }
    }
}
