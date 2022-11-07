package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final List<Integer> computerNumber;
    private int ball;
    private int strike;
    private int nothing;
    private final int NUMBER_LENGTH = 3;

    BaseballGame() {
        this.computerNumber = this.createComputerNumber();
        this.ball = 0;
        this.strike = 0;
        this.nothing = 0;
    }

    public List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public String startMatch(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            ballOrStrikeOrNothing(i, Integer.parseInt(String.valueOf(inputValue.charAt(i))));
        }
        return getMatchResult();
    }

    private void ballOrStrikeOrNothing(int index, int value) {
        if (this.computerNumber.contains(value)) {
            if (this.computerNumber.indexOf(value) == index) {
                this.strike++;
                return;
            }
            this.ball++;
            return;
        }
        this.nothing++;
    }

    private String getMatchResult() {
        StringBuilder result = new StringBuilder();

        if (this.strike == NUMBER_LENGTH) {
            return this.strike + "스트라이크";
        }
        if (this.nothing == NUMBER_LENGTH) {
            return "낫싱";
        }
        if (this.ball > 0) {
            result.append(this.ball).append("볼 ");
        }
        if (this.strike > 0) {
            result.append(this.strike).append("스트라이크 ");
        }

        return result.toString();
    }
}