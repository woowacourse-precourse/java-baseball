package baseball.controller;

import java.util.List;

import static baseball.domain.Computer.score;
import static baseball.domain.Player.input;
import static camp.nextstep.edu.missionutils.Console.readLine;


public class GameController {

    public static boolean game(List<Integer> randomNum){

        boolean result = false;

        String userNum = input();
        String[] userNumArr = userNum.split("");

        result = score(userNum, randomNum, userNumArr, result);

        return result;
    }

}
