package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayBallUI {
    public void startInterface(){
        showWelcomeMessage();
    }

    public void showWelcomeMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String takeUserInput(){
        String userNumberInput = readLine();
        return userNumberInput;
    }

    public void showJudgeMessage(int strike, int ball){
        if (strike != 0 && ball != 0){
            System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
        }
        else if (strike != 0 && ball == 0){
            System.out.println(String.format("%d스트라이크", strike));
        }
        else if (strike == 0 && ball != 0){
            System.out.println(String.format("%d볼", ball));
        }
        else if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        }
    }
}
