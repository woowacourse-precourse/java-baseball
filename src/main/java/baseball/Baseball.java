package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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

    /**
     * 숫자 비교 후 카운트 갯수 구하는 함수
     * @param userInput
     * @return 최종 볼과 스트라이크 갯수
     */
    public List<Integer> getTotalBallCount(String userInput) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < userInput.length(); i++) {
            int number = userInput.charAt(i) - '0';
            if (number == gameNumber.get(i)) {
                strikeCount++;
            } else if (gameNumber.contains(number)) {
                ballCount++;
            }
        }
        return Arrays.asList(ballCount, strikeCount);
    }
}
