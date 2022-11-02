package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int NUMBER_MAX_RANGE = 3;
    private static final String NUMBER_SEPARATE_DELIMITER = "";
    private static final String NUMBER_RANGE = "^[1-9]*$";

    public static List<Integer> inputPlayerNumber() {
        System.out.println(GAME_START_MESSAGE);
        System.out.print(GET_NUMBER_MESSAGE);

        String playerBallNumbers = Console.readLine();
        validateBallNumber(playerBallNumbers);

        return Arrays.stream(separate(playerBallNumbers)).map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    private static void validateBallNumber(String playerBallNumbers) {
        if (!Pattern.matches(NUMBER_RANGE, playerBallNumbers)) {
            throw new IllegalArgumentException();
        }
        if (playerBallNumbers.length() != NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException();
        }
        String[] numbers = separate(playerBallNumbers);
        Set<String> ballNums = new HashSet<>(Arrays.asList(numbers));

        if (ballNums.size() != numbers.length) {
            throw new IllegalArgumentException();
        }

    }


    private static String[] separate(String input) {
        return input.split(NUMBER_SEPARATE_DELIMITER);
    }
}
