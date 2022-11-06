package baseball.util;

import baseball.message.SystemMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BallGenerator {

    public static final int COMPUTER_BALLS_SIZE = 3;

    public List<Integer> createComputerBall() {
        List<Integer> computerBalls = new ArrayList<>();
        while (computerBalls.size() < COMPUTER_BALLS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBalls.contains(randomNumber)) {
                computerBalls.add(randomNumber);
            }
        }
        return computerBalls;
    }

    public List<Integer> createPlayerBall() {
        System.out.print(SystemMessage.ENTER_NUMBER);
        String playerBall = Console.readLine();
        List<Integer> playerBalls = stringToIntegerList(playerBall);
        if (!InputValidator.checkPlayerBall(playerBalls)) {
            throw new IllegalArgumentException();
        }
        return playerBalls;
    }

    private List<Integer> stringToIntegerList(String num) {
        return Arrays.stream(num.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
