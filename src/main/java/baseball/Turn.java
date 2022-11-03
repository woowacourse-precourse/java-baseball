package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Turn {
    private static final String ASK_FOR_NUMBER = "숫자를 입력해주세요 : ";
    private List<Integer> playerNumberList;

    public Turn() {
    }

    public String getPlayerInput() {
        System.out.print(ASK_FOR_NUMBER);
        return Console.readLine();
    }
}
