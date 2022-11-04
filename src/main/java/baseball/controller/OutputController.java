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

    public boolean gameResult(ComNumber comNumber, UserNumber userNumber) {
        boolean gameResult = false;
        int strike = getStrike(comNumber, userNumber);
        int ball = getBall(comNumber, userNumber);
        if(strike == InputController.NUMBER_SIZE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameResult = true;
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return gameResult;
    }
}
