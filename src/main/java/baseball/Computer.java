package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static constants.GameConstant.*;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber = new ArrayList<>();

    public void makeComputerNumber() {
        while (computerNumber.size() < GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            addComputerNumber(computerNumber, randomNumber);
        }
    }

    private static void addComputerNumber(List<Integer> computerNumber, int randomNumber) {
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    public boolean isNotThreeStrike(List<String> playerNumber) {
        return
    }

    public void checkNumber(List<String> playerNumber) {
        //스트라이크, 볼, 낫싱 검사 후 결과 출력
        int strikeCount = 0;
        int ballCount = 0;
        boolean nothing = isNothing(strikeCount, ballCount);
        for (int i = 0; i < 3; i++) {
            strikeCount += countStrike(computerNumber.get(i), playerNumber.get(i));
            ballCount += countBall(computerNumber.get(i), playerNumber.get(i));
        }
        String ComputerResult = getComputerResult(strikeCount, ballCount, nothing);
        System.out.println(ComputerResult);
    }

    private int countStrike(Integer eachComputerNumber, String eachPlayerNumber) {
        if (eachComputerNumber == Integer.parseInt(eachPlayerNumber)) {
            return 1;
        }
        return 0;
    }


}
