package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameScore {

    List<String> GAME_VALUE = Arrays.asList("스트라이크", "볼", "낫싱");

    public GameScore() {

    }

    public int CheckStrikes(List<Integer> computer, List<Integer> player) {
        int strikes = 0;

        for(int i = 0; i < computer.size(); i++) {
            if(computer.get(i).equals(player.get(i))) {
                strikes++;
            }
        }

        return strikes;
    }

    public int CheckBalls(List<Integer> computer, List<Integer> player) {
        int balls = 0;

        for(int i = 0; i < computer.size(); i++) {

            int intPlayer = player.get(i);

            if(computer.contains(intPlayer)) {
                balls++;
            }
        }

        return balls;
    }

    public String CheckNothing(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            return "낫싱";
        }
        return "";
    }

    public String ReturnScore(int strike, int ball) {
        if(CheckNothing(strike, ball).equals(GAME_VALUE.get(2))) {
            return GAME_VALUE.get(2);
        }

        ball -= strike;

        return ReturnStrikeOrBall(strike, ball);
    }

    private String ReturnStrikeOrBall(int strike, int ball) {
        String strStrike = strike+GAME_VALUE.get(0);
        String strBall = ball+GAME_VALUE.get(1);

        if(ball == 0) {
            return strStrike;
        }
        if(strike == 0) {
            return strBall;
        }

        return strBall + " " + strStrike;
    }
}
