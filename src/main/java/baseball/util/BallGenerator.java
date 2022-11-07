package baseball.util;

import static baseball.constant.SystemValue.BALL_MAXIMUM_VALUE;
import static baseball.constant.SystemValue.BALL_MINIMUM_VALUE;
import static baseball.constant.SystemValue.COMPUTER_BALLS_SIZE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BallGenerator {

    public List<Integer> createComputerBalls() {
        List<Integer> computerBalls = new ArrayList<>();
        while (computerBalls.size() < COMPUTER_BALLS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BALL_MINIMUM_VALUE, BALL_MAXIMUM_VALUE);
            if (!computerBalls.contains(randomNumber)) {
                computerBalls.add(randomNumber);
            }
        }
        return computerBalls;
    }

    public List<Integer> createPlayerBalls() {
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
