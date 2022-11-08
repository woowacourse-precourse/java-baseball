package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class User {

    private static final String RESTART = "1";
    private static final String END = "2";

    public List<BallNumber> createBallNumber() {
        String ballNumbersString = Console.readLine();
        AtomicInteger index = new AtomicInteger();
        return ballNumbersString.chars()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .map(number -> new BallNumber(index.getAndIncrement(), number))
                .collect(Collectors.toList());
    }

    public String choiceRestartOrStop() {
        String input = Console.readLine();
        if (!(input.equals(RESTART) || input.equals(END))) {
            throw new IllegalArgumentException("게임을 재시작하려면 1번을, 게임을 종료하려면 2번을 입력해주세요.");
        }
        return input;
    }
}
