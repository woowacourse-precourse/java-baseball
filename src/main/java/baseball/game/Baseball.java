package baseball.game;

import static baseball.util.ComputerUtil.getComputerNumbers;
import static baseball.util.UserUtil.getUserNumbers;

import java.util.List;

public class Baseball {

    private int strikeCount;
    private int ballCount;

    public void proceedGame() {
        while (true) {
            startGame();
        }
    }

    private void startGame() {
        List<Integer> computerNumbers = getComputerNumbers();

        while (true) {
            strikeCount = 0;
            ballCount = 0;

            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");

            List<Integer> userNumbers = getUserNumbers();

        }
    }
}
