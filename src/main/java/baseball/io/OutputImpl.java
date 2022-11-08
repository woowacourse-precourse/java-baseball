package baseball.io;

import baseball.model.BallCount;

public class OutputImpl implements Output {
    @Override
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void ballCount(BallCount bc) {
        if (bc.getBall() == 0 && bc.getStrike() == 0) System.out.println("낫싱");
        if (bc.getBall() > 0) System.out.print(bc.getBall() + "볼 ");
        if (bc.getStrike() > 0) System.out.println(bc.getStrike() + "스트라이크");
        else System.out.print("\n");
    }

    @Override
    public void correct() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void end() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
