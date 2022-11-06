package baseball;

import java.util.List;

public class Game {

    private int strike = 0;
    private int ball = 0;

    List<Integer> comNum;
    List<Integer> userNum;


    public void playGame() {
        comNum = ComputerNumber.getComputerNumber();
        userNum = User.userInputNumber();
        cnt_StrikeOrBall();
    }

    public void cnt_StrikeOrBall() {
        for (int i = 0; i < userNum.size(); i++) {
            if (comNum.indexOf(userNum.get(i)) == i) {
                strike++;
                continue;
            }
            if (comNum.contains(userNum.get(i))) {
                ball++;
            }
        }
    }
}
