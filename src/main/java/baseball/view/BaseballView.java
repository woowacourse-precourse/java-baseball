package baseball.view;

import java.util.List;

public class BaseballView {
    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final int NOTHING = 2;

    public void printGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printHint(List<Integer> hints) {
        StringBuilder sb = new StringBuilder();
        if (hints.get(NOTHING) == 3) {
            System.out.println("낫싱");
            return;
        }
        if (hints.get(BALL) > 0) {
            sb.append(hints.get(BALL)).append("볼").append(" ");
        }
        if (hints.get(STRIKE) > 0) {
            sb.append(hints.get(STRIKE)).append("스트라이크");
        }
        System.out.println(sb);
    }

    public void resumeOrQuitGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
