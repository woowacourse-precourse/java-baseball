package baseball;

import baseball.controller.GameController;
import baseball.service.ComputerService;
import baseball.view.GameStartView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    /*
    Concept
    mvc 모델 활용
    1. View 에서 이벤트 수행
    2. Controller 에서 수행할 메소드를 Model에 전송
    3. Model에서 메소드를 수행하고 결과물을 Controller에 반환
    4. Controller에서 반환받은 내용을 View로 반환
    5. View 에서 이벤트 결과 확인
     */
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.gameStart();
    }
}
