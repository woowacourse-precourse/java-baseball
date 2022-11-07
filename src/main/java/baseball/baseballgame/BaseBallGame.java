package baseball.baseballgame;

import baseball.baseballgame.balls.Balls;
import baseball.inputview.InputView;
import baseball.outview.OutView;
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

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        InputView inputView = new InputView();
        String ballNumbers = inputView.inputNumber();
        List<Integer> report = this.checkUserBallList(ballNumbers);
        OutView.print(report);
        boolean flag = GameOverChecker.check(report);
        while (!flag) {
            ballNumbers = inputView.inputNumber();
            report = checkUserBallList(ballNumbers);
            OutView.print(report);
            flag = GameOverChecker.check(report);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        if (inputView.ask_restart()) {
            BaseBallGame baseBallGame = new BaseBallGame();
            baseBallGame.start();
        }
    }

    public List<Integer> checkUserBallList(String userInoutNumber) {
        List<Integer> userBallList = NumberToListChanger.change(userInoutNumber);
        return computerBallList.judge(new Balls(userBallList)).reportToList();
    }
}
