package baseball.view;

import baseball.vo.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerInputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int VALID_INPUT_LENGTH = 3;
    private static final String POSSBILE_CHARACTER = "^[1-9]{3}";
    private static String line;
    public static Player selectNumbers() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println(ASK_USER_INPUT_MESSAGE);
        line = Console.readLine();
        validateUserInput(line);
        Player userSelectNumbers = getUserSelectNumbers(line);
        return userSelectNumbers;
    }

    private static void validateUserInput(String playerInput) {
        validateNumbersLength(playerInput);
        validateDuplicateNumber(playerInput);
        validateOnlyNumber(playerInput);
    }
    private static void validateNumbersLength(String playerInput) {
        if (playerInput.length() != VALID_INPUT_LENGTH)
            throw new IllegalArgumentException("Invalid input length");
    }
    private static void validateDuplicateNumber(String playerInput) {
        Set<Character> charset = new HashSet<>();
        for (int i = 0; i < playerInput.length(); ++i) {
            charset.add(playerInput.charAt(i));
        }
        if (charset.size() != VALID_INPUT_LENGTH)
            throw new IllegalArgumentException("Duplicate input character");
    }
    private static void validateOnlyNumber(String playerInput) {
        if (!playerInput.matches(POSSBILE_CHARACTER))
            throw new IllegalArgumentException("Invalid input character");
    }




    private static Player getUserSelectNumbers(String userInput) {
        List<Integer> userSelectNumbers = Arrays.stream(line.split(""))
                .map(element-> Integer.parseInt(element))
                .collect(Collectors.toList());
        return new Player(userSelectNumbers);
    }
}
