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

    private void countStrikeAndBall(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < 3; i++) {
            String result = getStrikeOrBall(computerNumbers, userNumbers.get(i), i);

            if (result.equals("스트라이크")) {
                strikeCount++;
            }

            if (result.equals("볼 ")) {
                ballCount++;
            }
        }
    }

    private String getStrikeOrBall(List<Integer> computerNumbers, int userNumber, int index) {
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i) == userNumber && i == index) {
                return "스트라이크";
            }

            if (computerNumbers.get(i) == userNumber) {
                return "볼 ";
            }
        }

        return "낫싱";
    }
}
