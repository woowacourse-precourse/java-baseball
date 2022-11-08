package baseball.service;

import baseball.domain.GameDomain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {
    private static final int maxNum = 9;
    private static final int minNum = 1;

    public static boolean isContinue = true;
    public static boolean compareAnswer(List<Integer> player, List<Integer> computer) { //Game Class
        int ballCount;
        int strikeCount;
        ballCount = GameDomain.countBall(player, computer);
        strikeCount = GameDomain.countStrike(player, computer);
        if (ballCount != 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크 ");
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public static List<Integer> makeComputerNumber() { //Game Class
        List<Integer> computerNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            computerNumber.add(pickNumberInRange(minNum, maxNum));
        }
        return computerNumber;
    }
}
