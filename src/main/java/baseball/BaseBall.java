package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseBall {

    Set<Integer> gameBall = new Ball().getNumber();
    Set<Integer> userBall = new HashSet<>();

    public void startGame() {
        String input = Console.readLine();
    }

    public void readNumber(String input) {
        Set<Integer> userNumber = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        userBall.addAll(userNumber);
    }

    public void validateInputSize() {

    }

    public void validateInputType() {

    }

    public void validateInputUnique() {

    }

    public Set<Integer> getUserBall() {
        return userBall;
    }
}
