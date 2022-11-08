package baseball.view;

import static baseball.utils.InputValidation.validateIsAllDigit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import baseball.game.GameOption;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String GET_BALL_NUMBERS = "숫자를 입력해주세요 : ";

    private static final String GET_GAME_OPTION
        = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static List<Integer> getBallNumbers() {
        System.out.print(GET_BALL_NUMBERS);
        String ballNumbers = Console.readLine();
        validateIsAllDigit(ballNumbers);

        return Arrays.stream(ballNumbers.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static GameOption getGameOption() {
        System.out.println(GET_GAME_OPTION);
        String gameOption = Console.readLine();
        validateIsAllDigit(gameOption);
        return GameOption.of(Integer.parseInt(gameOption));
    }
}
