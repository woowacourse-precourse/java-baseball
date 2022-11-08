package baseball.view;

import baseball.vo.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerInputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static String line;
    public static Player selectNumbers() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println(ASK_USER_INPUT_MESSAGE);
        Player userSelectNumbers = getUserSelectNumbers(Console.readLine());
        validateUserInput();
        // input error handling
        return userSelectNumbers;
    }

    private static Player getUserSelectNumbers(String userInput) {
        List<Integer> userSelectNumbers = Arrays.stream(line.split(""))
                .map(element-> Integer.parseInt(element))
                .collect(Collectors.toList());
        return new Player(userSelectNumbers);
    }
}
