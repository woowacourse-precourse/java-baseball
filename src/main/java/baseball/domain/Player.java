package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    List<String> playersNumber = new ArrayList<>();

    public void EnterNumberOfPlayer() {
        System.out.print("숫자를 입력해주세요 : ");
        List<String> inputData = Arrays.asList(Console.readLine().split(""));
        InputException.checkExceptionNumber(inputData);
        playersNumber = inputData;
    }
}
