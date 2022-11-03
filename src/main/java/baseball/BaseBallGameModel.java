package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameModel {
    private int ball, strike;
    private List<Integer> computerNumbers = new ArrayList<>();
    private boolean isFinish;

    public int ballCount(List<Integer> userNumbers) {
        ball = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.contains(userNumbers.get(i))
                    && computerNumbers.get(i) != userNumbers.get(i))
                ball++;
        }

        return ball;
    }

    public int strikeCount(List<Integer> userNumbers) {
        strike = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i) == userNumbers.get(i))
                strike++;
        }

        if (strike == 3)
            isFinish = true;

        return strike;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void createRandomNumber() {
        computerNumbers.clear();
        isFinish = false;

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumbers.contains(randomNumber))
                computerNumbers.add(randomNumber);
        }
    }
}
