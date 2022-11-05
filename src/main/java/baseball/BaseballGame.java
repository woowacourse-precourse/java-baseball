package baseball;

import constant.Const;
import util.RamdomNumber;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    RamdomNumber randomNumber;
    int[] answer;
    User user;
    Hint hint;

    BaseballGame() {
        this.randomNumber = new RamdomNumber(Const.NUMBER_LENGTH);
        this.answer = new int[Const.NUMBER_LENGTH];
        this.user = new User();
        this.hint = new Hint();
    }

    public void startGame() {
        System.out.println(Const.GAME_START);
        answer = randomNumber.makeRandomNumber(Const.NUMBER_LENGTH);
        do {
            hint.getHint(user.userNumber(), answer);
        } while (hint.strike != 3);
    }
    public boolean doneGame() {
        System.out.println(Const.GAME_DONE);
        return restartGame();
    }

    private boolean restartGame() {
        System.out.println(Const.GAME_RESTART);
        int input = Integer.parseInt(Console.readLine());
        if (input == Const.RESTART) {
            return true;
        } else if (input == Const.EXIT){
            return false;
        } else {
            throw new IllegalArgumentException(Const.INPUT_WRONG);
        }
    }
}
