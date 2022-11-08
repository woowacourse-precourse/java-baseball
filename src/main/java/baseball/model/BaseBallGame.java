package baseball.model;

import baseball.model.balls.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private static final int MAX_SIZE = 3;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    private final Balls computerBallList;

    public BaseBallGame() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computerBallList = new Balls(computer);
    }

    public List<Integer> checkUserBallList(String userInoutNumber) {
        List<Integer> userBallList = NumberToListChanger.change(userInoutNumber);
        return computerBallList.judge(new Balls(userBallList)).reportToList();
    }
}
