package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        RandomNumber randomNumber = new RandomNumber();
        
        ShowMessage.showGameStart(); // 게임 시작 메세지 출력
        ShowMessage.showInputNumber(); // 숫자 입력 메세지 출력
        gameController.inputUserNumber(); // 사용자 입력
        randomNumber.createRandomNumber(); // 난수 생성
        
    }

}
