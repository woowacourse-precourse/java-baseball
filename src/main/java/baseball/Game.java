package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> computer = new ArrayList<>();

    public Game() {
        UserInput userInput = new UserInput();

        generateNum();

        while (true) {
            BallCount ballcounter = new BallCount();
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> user = userInput.getInput();
            checkInput(user, ballcounter);

            if (isGameEnd(ballcounter)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    private boolean isGameEnd(BallCount ballcounter) {
        if (ballcounter.getStrike() == 3) {
            return true;
        }
        return false;
    }

    public List<Integer> getComputer() {
        generateNum();
        return computer;
    }

    private void generateNum() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNum(computer, randomNumber);
        }
    }

    private void addNum(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    private void checkInput(List<Integer> user, BallCount ballcounter) {
        for (int idx = 0; idx < 3; idx++) {
            ballcounter.checkStrikeOrBall(user, computer, idx);
        }

        System.out.println(ballcounter.toString());
    }
}
