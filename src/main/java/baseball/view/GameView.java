package baseball.view;

import baseball.object.GameResult;
import camp.nextstep.edu.missionutils.Console;

public class GameView {

    public static void printStartView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputView() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static String getInputNumber() {
        return Console.readLine();
    }

    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printGameResult(GameResult gameResult) {

        if (gameResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(gameResult.getBall()).append("볼 ");
        sb.append(gameResult.getStrike()).append("스트라이크");
        System.out.println(sb);
    }
}
