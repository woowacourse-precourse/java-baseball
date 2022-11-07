package baseball;

import camp.nextstep.edu.missionutils.Console;


/**
 * 야구게임 시작 사용자가 1을 입력할 시 계속, 2를 입력할 시 중단합니다.
 *
 * @throws IllegalArgumentException 선택지에서 1~2사이 값이 아닌 값을 넣은 경우
 */
public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        int select = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (select == 1) {
            game.start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            select = Integer.parseInt(Console.readLine());
            if (select != 1 && select != 2) {
                throw new IllegalArgumentException();
            }
        }
    }
}
