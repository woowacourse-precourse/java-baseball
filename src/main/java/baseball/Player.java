package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    List<String> usersNumber = new ArrayList<>();

    public void EnterNumberOfPlayer() {
        System.out.print("숫자를 입력해주세요 : ");
        String[] enteredNumber = Console.readLine().split("");
        // 입력된 숫자가 올바른지 테스트하는 부분 (예외 처리, 중복된 숫자가 입력되었는지)
        usersNumber = Arrays.asList(enteredNumber);
    }
}
