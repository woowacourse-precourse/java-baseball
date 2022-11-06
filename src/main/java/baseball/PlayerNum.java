package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerNum implements Number {


    @Override
    public void verifyNumber(List<Integer> numbers) {

    }

    @Override
    public List<Integer> createNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> number = Arrays.asList(Integer.parseInt(input));
        return number;
    }

}
