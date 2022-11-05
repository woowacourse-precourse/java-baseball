package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    public List<Integer> inputUserNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        List<Integer> inputNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            inputNumberList.add(inputNumber.charAt(i) - '0');
        return inputNumberList;
    }

}
