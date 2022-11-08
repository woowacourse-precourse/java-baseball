package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUserNumber {

    public static List<Integer> playerNumber(){


        int playerNumString = Integer.parseInt(Console.readLine());



        List<Integer> userNumber = new ArrayList<>();

        for (int i = 0; i < 3 ; i++) {
            userNumber.add(playerNumString%10);
            playerNumString /= 10;
        }

        return userNumber;
    }


}
