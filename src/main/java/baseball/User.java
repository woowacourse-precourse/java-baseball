package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class User {

    public static List<Integer> inputBalls() {
        System.out.println("숫자야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String userInput =Console.readLine();
        System.out.print(userInput);

        return new ArrayList<Integer>() ;
    }
}
