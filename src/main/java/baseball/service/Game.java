package baseball.service;

import baseball.domain.Number;
import baseball.domain.Numbers;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private static final StringBuilder RESULT = new StringBuilder();
    private static final String BLANK = "";
    private static final int INITIALIZE = 0;

    private Game() {
    }

    public static void start() {
        Numbers computer = new Numbers(getComputerInput());
        play();
    }

    private static List<Number> getComputerInput() {
        return IntStream.range(0, 3)
                .map(n -> Randoms.pickNumberInRange(1, 9))
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    private static void play() {
        RESULT.setLength(INITIALIZE);
        View.printInputRequest();
        Numbers player = new Numbers(getPlayerInput());
    }

    private static List<Number> getPlayerInput() {
        String input = Console.readLine();
        checkBlank(input);
        return IntStream.range(0, input.length())
                .mapToObj(n -> new Number(input.charAt(n)))
                .collect(Collectors.toList());
    }

    private static void checkBlank(String input) {
        if (input.equals(BLANK)) {
            throw new IllegalArgumentException("값이 입력되지 않았습니다.");
        }
    }
}
