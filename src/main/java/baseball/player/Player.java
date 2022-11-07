package baseball.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private static List<Integer> inputNum;
    private static final String INPUT_STRING = "숫자를 입력해주세요 : ";

    public void inputNumber(){
        System.out.print(INPUT_STRING);
        String input = Console.readLine();
        checkValidateInput(input);
        setInputNum(input);
    }

    public void checkValidateInput(String input){
        List<Integer> tempInput = new ArrayList<>();

        isInt(input);

        tempInput = changeInputToList(input);

        checkInputLength(tempInput);
        isIntRange(tempInput);
        isDifferent(tempInput);
    }

}
