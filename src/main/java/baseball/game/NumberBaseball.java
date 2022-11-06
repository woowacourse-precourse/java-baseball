package baseball.game;

import java.util.List;

public class NumberBaseball {
    private final Staff staff = new Staff();
    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            List<Integer> targetNumbers = staff.getTargetNumbers();
            repeatUntilUserGetsPerfectAnswer(targetNumbers);
        } while (isUserWantMoreGame());
    }
}
