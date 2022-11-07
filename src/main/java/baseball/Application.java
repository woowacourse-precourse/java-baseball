package baseball;


import static baseball.Constant.GAME_START;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Application {



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GAME_START);

        Map<Integer, Integer> computer = Player.createComputerNumber();

        String readLine = Console.readLine();
        Map<Integer, Integer> user = Input.inputUserNumber(readLine);

        Hint.loopHint(user, computer);


        Game.playGame();






    }


}
