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

}
