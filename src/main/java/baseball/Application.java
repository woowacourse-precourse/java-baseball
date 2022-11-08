package baseball;

import baseball.domain.BaseballGame;

/**
 * 기능 목록
 * 1. 컴퓨터가 3개의 서로 다른 1~9의 수를 선택할 수 있어야 한다.
 * 2. 사용자는 3개의 서로 다른 1~9의 수를 입력할 수 있어야 한다.
 * 3. Strike, Ball, Nothing 이라는 값을 계산해야 한다.
 * 4. 3번 기능에서 구한 값을 사용자에게 보여줘야 한다.
 * 5. 다 맞춘 후, 1(재시작), 2(종료) 버튼을 통해 사용자는 게임을 재시작 하거나 종료할 수 있다.
 */
public class Application {

    public static void main(String[] args) {
        new BaseballGame().start();
    }
}
