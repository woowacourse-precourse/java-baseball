package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    private static final int NUMBER_LENGTH = 3;

    private List<Character> getComputerNumberList() {
        ComputerNumber computerNumber = new ComputerNumber();
        List<Character> computerNumberList = computerNumber.getNumberList();
        return computerNumberList;
    }

    private String printState(int strike, int ball) {
        String state = "";
        if (ball != 0) {
            state += ball + "볼";
        }
        if (strike != 0) {
            if(ball != 0) state += " ";
            state += strike + "스트라이크";
        }
        return state;
    }

    private int countStrike(List<Character> computerNumber, List<Character> userNumber) {
        int strike = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    private int countBall(List<Character> computerNumber, List<Character> userNumber) {
        int ball = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (!computerNumber.get(i).equals(userNumber.get(i)) && computerNumber.contains(userNumber.get(i))) {
                ball += 1;
            }
        }
        return ball;
    }

    private boolean checkNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }
}
