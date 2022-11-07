package baseball.ui;

import baseball.game.Decision;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RE_GAME_DECISION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String PATTERN = "[1-9]{3}";

    private InputView() {
    }

    public static String numbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String input = readLine();
        validate(input);
        return input;
    }

    public static Decision decision() {
        System.out.println(RE_GAME_DECISION_MESSAGE);
        return Decision.from(readLine());
    }

    private static void validate(String input) {
        if (!input.matches(PATTERN)) {
            throw new IllegalArgumentException();
        }
    }
}
