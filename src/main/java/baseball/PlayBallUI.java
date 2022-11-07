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
}
