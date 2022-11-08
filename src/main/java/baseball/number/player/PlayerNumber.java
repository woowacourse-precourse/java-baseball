package baseball.number.player;

import baseball.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {

    private final Validation validation = new Validation();


    public String inputPlayerNumber() { //사용자 입력
       return Console.readLine();
   } //plyer input

    public List<Integer> playerNumberToList(){

        String playerNumber = inputPlayerNumber(); //input
        List<Integer> playerNumberList = stringToNumberList(playerNumber); //string to List<Integer>

        validation.validatePlayerNumbers(playerNumberList); //validation

        return playerNumberList;
    }

    private List<Integer> stringToNumberList(String number) {
        List<Integer> playerNumberList = new ArrayList<>();
        char[] strNumberArr = number.toCharArray();
        for(char charNumber : strNumberArr) {
            playerNumberList.add(charNumber - '0');
        }
        return playerNumberList;
    }
}
