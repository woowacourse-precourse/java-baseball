package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    public static final int GAME_NUMBER_SIZE = 3;

    List<Integer> gameNumber = new ArrayList<>();

    public Baseball() {
        this.setRandomNumber();
    }

    /**
     * 컴퓨터 숫자 : GameNumber 초기 값 설정하는 함수
     */
    public void setRandomNumber() {
        while (gameNumber.size() < GAME_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!gameNumber.contains(randomNumber)) {
                gameNumber.add(randomNumber);
            }
        }

    }

    public List<Integer> getGameNumber() {
        return gameNumber;
    }
}
