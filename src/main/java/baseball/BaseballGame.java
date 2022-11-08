package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final String BALL_STR = "볼";
    private static final String STRIKE_STR = "스트라이크";
    private static final String NOTHING_STR = "낫싱";
    private static final String END_RESULT_STR = "3스트라이크";

    List<Integer> randomList = new ArrayList<>();
    String gameResult;
    int ballCnt = 0;
    int strikeCnt = 0;

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        createNumber();
    }

    private void createNumber() {
        while (randomList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            addRandomNumber(randomNumber);
        }
    }

    private void addRandomNumber(int randomNumber) {
        if (!randomList.contains(randomNumber)) {
            randomList.add(randomNumber);
        }
    }

    public int checkGameResult(int comparativeNumbers) {
        countBallStrike(comparativeNumbers);

        int status = 0;
        String strikeCntString = Integer.toString(strikeCnt);
        String ballCntString = Integer.toString(ballCnt);

        if (strikeCnt == 0 && ballCnt == 0) {
            gameResult = NOTHING_STR;
        } else if (ballCnt == 0) {
            gameResult = strikeCntString+STRIKE_STR;
        } else if (strikeCnt == 0) {
            gameResult = ballCntString+BALL_STR;
        } else {
            gameResult = ballCntString+BALL_STR+" "+strikeCntString+STRIKE_STR;
        }

        System.out.println(gameResult);
        status = checkEndGame(status);

        return status;
    }

    private int checkEndGame(int status) {
        if(gameResult.equals(END_RESULT_STR)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            status = 1;
        }

        return status;
    }

    private void countBallStrike(int comparativeNumbers) {
        String comparativeString = Integer.toString(comparativeNumbers);
        initCount();

        for(int i = 0; i < 3; i++) {
            compareNumber(randomList.get(i), comparativeString.charAt(i) - '0');
        }
    }

    private void initCount() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    private void compareNumber(int originalNumber, int comparativeNumber) {
        if (originalNumber == comparativeNumber) {
            strikeCnt ++;
        } else if (randomList.contains(comparativeNumber)) {
            ballCnt ++;
        }
    }

    public void resetGame() {
        randomList.clear();
        createNumber();
    }
}
