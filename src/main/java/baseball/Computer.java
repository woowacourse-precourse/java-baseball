package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.stream.IntStream;

public class Computer {
    private String answer;

    public void setAnswer() {
        StringBuilder answerBuilder = new StringBuilder();
        HashSet<Integer> numSet = new HashSet<>();

        while (numSet.size() < Constants.NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Constants.NUMBER_RANGE_START, Constants.NUMBER_RANGE_END);
            if (numSet.add(randomNumber)) {
                answerBuilder.append(randomNumber);
            }
        }

        this.answer = answerBuilder.toString();
    }

    public int computeResult(String input) {
        int ball = countBall(input);
        int strike = countStrike(input);

        if (ball == 0 && strike == 0) {
            System.out.print(Format.NOTHING.format());
        }

        if (ball > 0) {
            System.out.printf(Format.BALL.format(), ball);
        }

        if (strike > 0) {
            System.out.printf(Format.STRIKE.format(), strike);
        }

        System.out.println();
        return strike;
    }

    private int countBall(String Input) {
        int ball;

        ball = (int) IntStream.range(0, Input.length()).
                filter(guessIdx -> IntStream.range(0, answer.length()).
                        filter(answerIdx -> guessIdx != answerIdx).
                        anyMatch(answerIdx -> Input.charAt(guessIdx) == answer.charAt(answerIdx))).
                count();

        return ball;
    }

    private int countStrike(String input) {
        int strike;

        strike = (int) IntStream.range(0, input.length()).
                filter(idx -> input.charAt(idx) == answer.charAt(idx)).
                count();

        return strike;
    }

    private enum Format{
        BALL("%d볼 "),
        STRIKE("%d스트라이크"),
        NOTHING("낫싱")
        ;
        private final String format;
        Format(String format){
            this.format = format;
        }
        private String format(){
            return format;
        }
    }
}
