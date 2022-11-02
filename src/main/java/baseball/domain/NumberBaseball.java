package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberBaseball {
    private String computerNumber;
    private String userNumber;
    private String gameResult;
    private int strike;
    private int ball;

    public NumberBaseball() {
        createComputerNumber();
    }

    private void createComputerNumber() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber))
                result.add(randomNumber);
        }
        computerNumber = result.stream().map(String::valueOf)
                .collect(Collectors.joining());
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public String getGameResult() {
        return gameResult;
    }
    public int getStrike() {
        return strike;
    }

    public void compareComputerNumberWith(String userNumber) {
        this.userNumber = userNumber;
        countBall();
        countStrike();
        checkIsEnd();
        makeGameResult();
    }

    private void countBall() {

    }

    private void countStrike() {
        this.strike = (int)IntStream.range(0, userNumber.length())
                .filter(index -> computerNumber.charAt(index) ==
                        userNumber.charAt(index))
                .count();
    }

    private void checkIsEnd() {

    }

    private void makeGameResult() {

    }
}
