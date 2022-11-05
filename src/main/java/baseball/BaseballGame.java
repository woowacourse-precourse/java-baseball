package baseball;

import Constant.Const;
import Util.RamdomNumber;
import java.util.Scanner;

import static Constant.Const.NUMBER_LENGTH;

public class BaseballGame {
    int[] answer;
    Hint hint;
    User user;
    RamdomNumber randomNumber;
    Scanner scanner = new Scanner(System.in);
    BaseballGame(){
        this.hint = new Hint();
        this.answer = new int[NUMBER_LENGTH];
        this.user = new User();
        this.randomNumber = new RamdomNumber(NUMBER_LENGTH);
    }

    public void startGame(){
        System.out.println(Const.GAME_START);
        answer = randomNumber.makeRandomNumber(NUMBER_LENGTH);
        do {
            user.UserInput();
            hint.getHint(user.getUserNumber(), answer);
        } while (hint.strike != 3);
    }
    public boolean doneGame(){
        System.out.println(Const.GAME_DONE);
        return restartGame();
    }

    private boolean restartGame(){
        System.out.println(Const.GAME_RESTART);
        int input = scanner.nextInt();
        if (input == Const.RESTART){
            return true;
        } else if (input == Const.EXIT){
            return false;
        } else {
            throw new IllegalArgumentException(Const.INPUT_WRONG);
        }
    }
}
