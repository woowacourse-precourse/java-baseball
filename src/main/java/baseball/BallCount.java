package baseball;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallCount {
    private int ballCount;
    private int strikeCount;

    public BallCount() { }

    public BallCount(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    // 볼 카운트 계산 method
    public void ruleBallCount(int targetNumber, int guessNumber){

    }

    // 스트라이크 카운트 계산 method
    public void ruleStrikeCount(int targetNumber, int guessNumber){
        targetNumber
    }

    private List<Integer> numberDigitToList(int number){
        return Arrays.stream(Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .toArray())
                .boxed().collect(Collectors.toList());
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    private void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    private void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

}
