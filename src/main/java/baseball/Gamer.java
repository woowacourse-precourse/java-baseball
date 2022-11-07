package baseball;

import camp.nextstep.edu.missionutils.Console;
import static baseball.Util.*;

import java.util.ArrayList;
import java.util.List;

public class Gamer {
    public List<Integer> gamerNumber = new ArrayList<>();

    public void checkException(String input_Number){
        isWeirdSize(input_Number);
        isNumber(input_Number);
        isSameEachNumber(input_Number);
    }

    public void inputNumber(){
        System.out.print("\n숫자를 입력해주세요 : ");
        String input_number = Console.readLine();
        checkException(input_number);
        int guess_number = Integer.parseInt(input_number);
        putInGamerNumber(guess_number);
    }
}
