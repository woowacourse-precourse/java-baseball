package baseball;

import java.util.ArrayList;
import java.util.List;

class PlayingBaseball {
    private final String numberOfComputer;
    private final String numberOfPlayer;
    private final int LENGTH = 3;
    private int strike = 0;
    private int ball = 0;
    private List indexOfStrike = new ArrayList<Integer>();

    PlayingBaseball (String numberComputer, String numberPlayer) {
        this.numberOfComputer = numberComputer;
        this.numberOfPlayer = numberPlayer;
    }

    int countStrikes () {
        for (int i = 0; i < LENGTH; i++) {
            if (numberOfComputer.charAt(i) == numberOfPlayer.charAt(i)) {
                indexOfStrike.add(i);
                strike += 1;
            }
        }
        return strike;
    }

    int countBalls () {
        for (int i = 0; i < LENGTH; i++) {
            String temp = String.valueOf(numberOfPlayer.charAt(i));
            if (!indexOfStrike.contains(i) && numberOfComputer.contains(temp)) {
                ball += 1;
            }
        }
        return ball;
    }

    void printResult () {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(strike+"스트라이크 "+ball+"볼");
    }







}
