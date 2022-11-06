package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayerInputView {
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String startInput(){
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
