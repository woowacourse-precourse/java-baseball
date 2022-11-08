package baseball;

import baseball.Controller.Controller;

/**
 * ## 예상 필요 기능.
 * 1. 같은 수가 있는가?
 * 2. 같은 자리에 있는가?
 * 3. 컴퓨터 차례
 * 4. 랜덤 1~9 선택
 * 5. 다시 시작하겠는가?
 * 6. 사용자 값이 잘못되었는가?(IllegalArgumentException)
 * 7. 3번 맞췄는가?
 */
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        controller.gameStart();
        boolean endPoint = true;
        while (endPoint!=false) {
            endPoint=controller.gameRestart();
        }

    }
}
