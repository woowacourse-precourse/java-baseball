package baseball.game;

import java.util.List;

public class NumberBaseball {
    private final Staff staff = new Staff();

    private final Referee referee = new Referee();

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            List<Integer> targetNumbers = staff.getTargetNumbers();
            repeatUntilUserGetsPerfectAnswer(targetNumbers);
        } while (isUserWantMoreGame());
    }

    private void repeatUntilUserGetsPerfectAnswer(List<Integer> targetNumbers) {

        do {
            List<Integer> userNumbers = staff.getUserNumbers();
        } while (referee.isPerfectAnswer(targetNumbers, userNumbers));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
