package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUserNumber {

    public static List<Integer> playerNumber(){
        ExcepetionCase exception = new ExcepetionCase();


        int playerNum = Integer.parseInt(Console.readLine());

        if (exception.ThreeNumberException(playerNum)){
            throw new IllegalArgumentException();
        }


        List<Integer> userNumber = new ArrayList<>();

        for (int i = 0; i < 3 ; i++) {
            userNumber.add(playerNum %10);
            playerNum /= 10;
        }

        return userNumber;
    }


}
