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
}
