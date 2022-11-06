package baseball.number.client;

import baseball.utils.validation.Validation;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {

   private Validation validation = new Validation();

    public List<Integer> playerNumberToList(String number){

        System.out.println(number);
        String playerNumber = validation.validatePlayerNumbers(number);

        List<Integer> digitNumbers = stringToNumberList(playerNumber);
        return digitNumbers;
    }

    public List<Integer> stringToNumberList(String number) {
        List<Integer> playerNumberList = new ArrayList<>();
        String[] strNumberArr = number.split("");
        for(String strNumber : strNumberArr) {
            playerNumberList.add(Integer.parseInt(strNumber));
        }
        return playerNumberList;
    }
}
