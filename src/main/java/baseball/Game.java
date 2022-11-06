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
        System.out.println(strike_ball_nothing_Message());
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

    public String strike_ball_nothing_Message() {
        String message;
        if (strike != 0 && ball == 0) {
            message = (strike + "스트라이크");
            return message;
        }
        else if (strike == 0 && ball !=0 ) {
            message = (ball + "볼");
            return message;
        }
        else if (strike != 0 && ball !=0) {
            message = (strike + "스트라이크" + ball +"볼");
            return message;
        }
        else {
            message = ("낫싱");
            return message;
        }
    }

}
