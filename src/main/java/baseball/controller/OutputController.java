package baseball.controller;

import baseball.domain.ComNumber;
import baseball.domain.UserNumber;

public class OutputController {

    public int getStrike(ComNumber comNumber, UserNumber userNumber) {
        int strike = 0;
        for(int i = 0; i< InputController.NUMBER_SIZE; i++) {
            int comnum = comNumber.getComnumber().get(i);
            int usernum = userNumber.getUserNumber().get(i);
            if(comnum == usernum) {strike++;}
        }
        return strike;
    }

    public int getBall(ComNumber comNumber, UserNumber userNumber) {
        int ball = 0;
        for(int i = 0; i< InputController.NUMBER_SIZE; i++) {
            Integer comnum = comNumber.getComnumber().get(i);
            int usernum = userNumber.getUserNumber().get(i);
            if(comnum != usernum && userNumber.getUserNumber().contains(comnum)) {ball++;}
        }
        return ball;
    }
}
