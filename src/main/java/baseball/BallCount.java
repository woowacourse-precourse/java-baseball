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
        int ballCount = 0;
        List<Integer> targetDigitList = numberDigitToList(targetNumber);
        List<Integer> guessDigitList = numberDigitToList(guessNumber);

        for (int i = 0; i < targetDigitList.size(); i++) {
            ballCount += compareDigitList(targetDigitList.get(i),guessDigitList,i);
        }
    }

    private int compareDigitList(int compareNumber, List<Integer> compareList, int exceptIndex){
        int result = 0;
        for(int i = 0; i < compareList.size(); i++) {
            if (i == exceptIndex){
                continue;
            }
            if (compareList.get(i) == compareNumber) {
                result++;
            }
        }

        return result;
    }

    // 스트라이크 카운트 계산 method
    public void ruleStrikeCount(int targetNumber, int guessNumber){
        int strikeCount = 0;
        List<Integer> targetDigitList = numberDigitToList(targetNumber);
        List<Integer> guessDigitList = numberDigitToList(guessNumber);

        for (int i = 0; i < targetDigitList.size(); i++) {
            if (targetDigitList.get(i) == guessDigitList.get(i)) {
                strikeCount++;
            }
        }

        this.strikeCount = strikeCount;
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
