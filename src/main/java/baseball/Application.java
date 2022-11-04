package baseball;

import baseball.util.BaseBallGame;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame(Randoms.pickUniqueNumbersInRange(0, 9, 3));

    }
}
