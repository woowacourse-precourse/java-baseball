package baseball.baseballgame;

import baseball.baseballgame.balllist.BallList;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BaseBallGame {

    private static final int MAX_SIZE = 3;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    private final BallList computerBallList;

    public BaseBallGame() {
        this.computerBallList =
                new BallList(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, MAX_SIZE));
    }

    private List<Integer> checkUserBallList(int userInoutNumber) {
        List<Integer> userBallList = NumberToListChanger.change(userInoutNumber);
        return computerBallList.judge(new BallList(userBallList)).reportToList();
    }
}
