package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import baseball.utils.Converter;

public class Game {
    private List<Integer> answer = new ArrayList<>();

    public Game(List<Integer> randomNumberList) {
        this.answer = randomNumberList;
    }

    public String getResult(String userAnswer) {
        int ball = 0;
        int strike = 0;
        String result = "";

        List<Integer> answerIntegerList = Converter.toIntegerList(userAnswer);
        for (int index = 0; index < answerIntegerList.size(); index++) {
            if (Objects.equals(answer.get(index), answerIntegerList.get(index))) {
                strike += 1;
                continue;
            }

            if (answer.contains(answerIntegerList.get(index))) {
                ball += 1;
            }
        }

        if (ball == 0) {
            result = strike + "스트라이크";
        }

        if (strike == 0) {
            result = ball + "볼";
        }

        if(ball != 0 && strike != 0) {
            result = ball + "볼 " + strike + "스트라이크";
        }

        if (ball == 0 && strike == 0) {
            result = "낫싱";
        }

        return result;
    }
}
