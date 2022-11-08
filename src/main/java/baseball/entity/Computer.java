package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static List<Integer> computerNumbers;

    public void createRandomNumber() {
        computerNumbers = new ArrayList<>();

        while(computerNumbers.size()<3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (computerNumbers.contains(number)) continue;
            computerNumbers.add(number);
        }
    }

    public void countBallAndStrike(List<Integer> playerNumbers, Score score) {
        for (int i=0; i<computerNumbers.size(); i++) {
            int playerNumber = playerNumbers.get(i);

            if(playerNumber == computerNumbers.get(i)) {
                score.increaseStrike(1);
                continue;
            }
            if(computerNumbers.contains(playerNumber)) {
                score.increaseBall(1);
            }
        }
    }
}
