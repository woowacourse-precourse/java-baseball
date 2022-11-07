package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baseball {
    public enum GameStatus {
        RESTART("1"),
        EXIT("2");

        private final String status;

        GameStatus(String status) {
            this.status = status;
        }

        public String getGameStatus() {
            return status;
        }
    }
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

    /**
     * 볼과 스트라이크 갯수로 힌트 출력 구문 생성
     * @param baseballCount
     * @return
     */
    public String getHintCode(List<Integer> baseballCount) {
        int ballCount = baseballCount.get(0);
        int strikeCount = baseballCount.get(1);

        if ((ballCount + strikeCount) == 0) {
            return "낫싱";
        }

        StringBuilder hintCode = new StringBuilder();

        if (ballCount != 0) {
            hintCode.append(ballCount+"볼");
        }

        if (strikeCount != 0) {
            hintCode.append(" "+strikeCount+"스트라이크");
        }

        return hintCode.toString().strip();
    }
}
