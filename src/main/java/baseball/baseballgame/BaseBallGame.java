package baseball.baseballgame;

import baseball.baseballgame.balllist.BallList;
import baseball.inputview.InputView;
import baseball.outview.OutView;
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

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        int ballNumbers = InputView.inputNumber();
        List<Integer> report = checkUserBallList(ballNumbers);
        OutView.print(report);
        boolean flag = GameOverChecker.check(report);
        while (!flag){
            ballNumbers = InputView.inputNumber();
            report = checkUserBallList(ballNumbers);
            OutView.print(report);
            flag = GameOverChecker.check(report);
        }
    }

    public List<Integer> checkUserBallList(int userInoutNumber) {
        List<Integer> userBallList = NumberToListChanger.change(userInoutNumber);
        return computerBallList.judge(new BallList(userBallList)).reportToList();
    }
}
