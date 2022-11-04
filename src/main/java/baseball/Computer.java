package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 상대방 역할을 할 컴퓨터 클래스 입니다.
 */
public class Computer {

    public List<Integer> completedDigits;
    public static final int RANDOM_NUMBER_MIN = 1;
    public static final int RANDOM_NUMBER_MAX = 9;
    public static final int RANDOM_NUMBER_LENGTH = 3;

    public Computer() {
        this.completedDigits = createRandomDigits();
    }

    /**
     * 1~9 사이의 랜덤한 숫자 3개를 만드는 메소드
     *
     * @return 랜덤한 숫자 3개가 들어있는 List
     */
    public List<Integer> createRandomDigits() {
        List<Integer> randomDigits = new ArrayList<>();
        boolean[] isDuplicated = new boolean[RANDOM_NUMBER_MAX + 1];

        while (randomDigits.size() < RANDOM_NUMBER_LENGTH) {
            int randomDigit = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);

            if (!isDuplicated[randomDigit]) {
                isDuplicated[randomDigit] = true;
                randomDigits.add(randomDigit);
            }
        }

        return randomDigits;
    }

    /**
     * 유저에게 입력받은 값과 컴퓨터가 생성한 랜덤값을 비교하여 결과를 반환하는 메소드
     * @param userInputDigits 유저가 입력한 값
     * @param computerRandomDigit 컴퓨터가 생성한 랜덤 값
     * @return 볼, 스트라이크, 낫싱 결과
     */
    public String checkDigits(List<Integer> userInputDigits, List<Integer> computerRandomDigit) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int digitIndex = 0; digitIndex < Computer.RANDOM_NUMBER_LENGTH; digitIndex++) {
            int userDigit = userInputDigits.get(digitIndex);
            int computerDigit = computerRandomDigit.get(digitIndex);

            if (userDigit == computerDigit) {
                strikeCnt++;
            }
            if (userDigit != computerDigit && computerRandomDigit.contains(userDigit)) {
                ballCnt++;
            }
        }

        if (strikeCnt == 0 && ballCnt == 0) {
            return "낫싱";
        } else if (strikeCnt == 0) {
            return ballCnt + "볼";
        } else if (ballCnt == 0) {
            return strikeCnt + "스트라이크";
        } else {
            return ballCnt + "볼" + " " + strikeCnt + "스트라이크";
        }

    }

}
