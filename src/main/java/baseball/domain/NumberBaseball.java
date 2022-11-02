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
    private boolean isEnd;

    public NumberBaseball() {
        createComputerNumber();
        isEnd = false;
    }

    public void resetGame() {
        createComputerNumber();
        isEnd = false;
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

    public void compareComputerNumberWith(String userNumber) {
        this.userNumber = userNumber;
        countStrike();
        countBall();
        checkEnd();
        makeGameResult();
    }

    private void countBall() {
        this.ball = (int)IntStream.range(0, userNumber.length())
                .filter(index -> computerNumber.
                        contains(Character.toString(userNumber.charAt(index))))
                .count() - this.strike;
    }

    private void countStrike() {
        this.strike = (int)IntStream.range(0, userNumber.length())
                .filter(index -> computerNumber.charAt(index) ==
                        userNumber.charAt(index))
                .count();
    }

    private void checkEnd() {
        if (this.strike == 3)
            isEnd = true;
        else
            isEnd = false;
    }

    private void makeGameResult() {
        StringBuilder result = new StringBuilder();
        if (this.ball > 0)
            result.append(this.ball + "볼 ");
        if (this.strike > 0)
            result.append(this.strike + "스트라이크\n");
        if (this.strike == 0 && this.ball == 0)
            result.append("낫싱");
        if (isEnd)
            result.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        gameResult = result.toString();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public String getGameResult() {
        return gameResult;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
