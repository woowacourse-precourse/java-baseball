package baseball;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallCount {
    private int ballCount;
    private int strikeCount;

    public BallCount() { }

    // 볼 카운트 계산 method
    public void ruleBallCount(List<Integer> targetNumber, int guessNumber){
        int ballCount = 0;
//        List<Integer> targetDigitList = numberDigitToList(targetNumber);
        List<Integer> guessDigitList = numberDigitToList(guessNumber);

        for (int i = 0; i < targetNumber.size(); i++) {
            ballCount += compareDigitList(targetNumber.get(i),guessDigitList,i);
        }

        this.ballCount = ballCount;
    }

    // 스트라이크 카운트 계산 method
    public void ruleStrikeCount(List<Integer> targetNumber, int guessNumber){
        int strikeCount = 0;
//        List<Integer> targetDigitList = numberDigitToList(targetNumber);
        List<Integer> guessDigitList = numberDigitToList(guessNumber);

        for (int i = 0; i < targetNumber.size(); i++) {
            if (targetNumber.get(i) == guessDigitList.get(i)) {
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

    private int compareDigitList(int compareNumber, List<Integer> compareList, int exceptIndex){
        if(compareList.contains(compareNumber) && compareList.get(exceptIndex) != compareNumber){
            return 1;
        }
        return 0;
    }

    public void printBallCount() {
        if(strikeCount == 3){
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } else if((ballCount == 0) && (strikeCount == 0)){
            System.out.println("낫싱");
        } else if((ballCount != 0) && (strikeCount == 0)) {
            System.out.println(ballCount + "볼");
        } else if((ballCount == 0) && (strikeCount != 0)) {
            System.out.println(strikeCount + "스트라이크");
        } else if((ballCount != 0) && (strikeCount != 0)) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public GuessResult getGuessResult() {
        if(strikeCount == 3){
            return GuessResult.END;
        } else if((ballCount == 0) && (strikeCount == 0)){
            return GuessResult.NOT_SWING;
        }

        return GuessResult.BALL_STRIKE;
    }

}
