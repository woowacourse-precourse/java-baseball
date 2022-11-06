package baseball.controller;

import baseball.model.ComNumber;
import baseball.model.UserNumber;
import baseball.view.OutputView;

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
        if(numOfStrikeBall(strike,ball).equals(OutputView.GAME_END)) {
            System.out.println(OutputView.THREESTRIKE);
            gameResult = true;
        }
        else {
            System.out.println(numOfStrikeBall(strike,ball));
        }
        return gameResult;
    }

    public String numOfStrikeBall(int strike,int ball) {
        String result = "";
        if(strike == InputController.NUMBER_SIZE) {
            result = OutputView.GAME_END;
        }
        else if(strike == 0 && ball == 0) {
            result = OutputView.NOTHING;
        }
        else {
            result = ball + "볼 " + strike + "스트라이크";
        }
        return result;
    }
}
