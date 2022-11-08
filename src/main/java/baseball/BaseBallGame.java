package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private static List<Integer> computerNumber;
    private static boolean isPlay = true;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isPlay) {
            play();
        }
    }

    private void play() {
        computerNumber = makeNumber();
    }

    public static List<Integer> makeNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
