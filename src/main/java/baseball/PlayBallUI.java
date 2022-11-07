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

    public List<Integer> takeUserInput(){
        //todo userNumber를 List로 바꿀지 아니면 계속 String을 사용할지 고민해보기
        String userNumberInput = readLine();
        List<Integer> userNumber = new ArrayList<>();

        for (int i = 0; i<userNumberInput.length(); i++){
            userNumber.add(userNumberInput.charAt(i) - '0');
        }

        return userNumber;
    }
}
