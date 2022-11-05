package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {

    private static final String GAME_START_SIGN = "숫자 야구 게임을 시작합니다.";
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 9;
    private static final int NUMBER_COUNT = 3;

    public static void main(String[] args) {
        notifyGameStart();
        List<Integer> computerNumbers = createComputerNumbers();
    }

    public static List<Integer> createComputerNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_VALUE, END_VALUE, NUMBER_COUNT);
    }

    public static void notifyGameStart() {
        System.out.println(GAME_START_SIGN);
    }

    public static String getHint(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int ballCnt = getBallCnt(computerNumbers, userNumbers);
        int strikeCnt = getStrikeCnt(computerNumbers, userNumbers);
        ballCnt -= strikeCnt;

        if (ballCnt == 0 && strikeCnt == 0) {
            return "낫싱";
        } else if (strikeCnt == 0) {
            return String.format("%d볼", ballCnt);
        } else if (ballCnt == 0) {
            return String.format("%d스트라이크", strikeCnt);
        } else {
            return String.format("%d볼 %d스트라이크", ballCnt, strikeCnt);
        }
    }

    private static int getStrikeCnt(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikeCnt = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikeCnt++;
            }
        }

        return strikeCnt;
    }

    private static int getBallCnt(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int ballCnt = 0;
        for (Integer userNumber : userNumbers) {
            if (computerNumbers.contains(userNumber)) {
                ballCnt++;
            }
        }
        return ballCnt;
    }
}
