package baseball.number.player;

import baseball.validation.Validation;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {

   private final Validation validation = new Validation();

    public List<Integer> playerNumberToList(String number){

        System.out.println(number);
        String playerNumber = validation.validatePlayerNumbers(number);

        return stringToNumberList(playerNumber);
    }

    private List<Integer> stringToNumberList(String number) {
        List<Integer> playerNumberList = new ArrayList<>();
        String[] strNumberArr = number.split("");
        for(String strNumber : strNumberArr) {
            playerNumberList.add(Integer.parseInt(strNumber));
        }
        return playerNumberList;
    }
}
