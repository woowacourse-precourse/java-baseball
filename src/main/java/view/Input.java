package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {

    /**
     * GamePlayer.saveNumbers 함수에 넣을 문자열을 받을 때 사용한다.
     *
     * @return GamePlayer.saveNumbers 함수에 넣을 문자열
     */
    public static String numbers() {
        Print.inputNumbers();
        return Console.readLine();
    }

    /**
     * 3스트라이크를 성공하여 재시작 또는 종료를 선택할 때 사용한다. 재시작일 경우 "1", 종료일 경우 "2"을 입력한다.
     *
     * @return 입력받은 문자열
     */
    public static String power() {
        return Console.readLine();
    }
}
