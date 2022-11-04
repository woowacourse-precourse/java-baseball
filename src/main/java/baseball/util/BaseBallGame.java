package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    private final List<Integer> computerRandomThreeValue;




    public BaseBallGame(List<Integer> computerRandomThreeValue) {
        this.computerRandomThreeValue = List.copyOf(computerRandomThreeValue);
    }


    public void gameStart () {
        String userData;
        do {

            userData = Console.readLine();
        } while (false);
    }

}
