package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 컴퓨터의 수를 생성하고, 사용자의 수와 비교하는 등 컴퓨터의 수와 관련된 책임을 갖는 클래스
 */
public class ComputerManager {
    private List<Integer> computerNumbers;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NONE = "낫싱";
    private static final int START_OF_NUMBER_RANGE = 1;
    private static final int END_OF_NUMBER_RANGE = 9;

    /**
     * 컴퓨터매니저 클래스가 가진 랜덤 수를 초기화하고,
     * 랜덤한 수를 생성하고 넣어주는 함수
     */
    public void generateRandomNumber() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < InputNumber.GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_OF_NUMBER_RANGE, END_OF_NUMBER_RANGE);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    /**
     * @param userNumber 유저가 입력한 수
     *                   유저가 입력한 수에 대해 현재 컴퓨터가 가지고 있는 수와 비교하여,
     *                   적절한 출력값을 반환하는 함수
     */
    public String compareWithUserNumber(String userNumber) {
        int ball = 0;
        int strike = 0;
        List<Integer> numbers = userNumberToList(userNumber);

        for (int i = 0; i < numbers.size(); i++) {
            if (Objects.equals(numbers.get(i), computerNumbers.get(i))) {
                strike++;
                continue;
            }

            if (computerNumbers.contains(numbers.get(i))) {
                ball++;
            }
        }

        return makeString(ball, strike);
    }

    private List<Integer> userNumberToList(String userNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < userNumber.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(userNumber.charAt(i))));
        }
        return numbers;
    }

    private String makeString(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return NONE;
        }
        if (ball == 0) {
            return strike + STRIKE;
        }
        if (strike == 0) {
            return ball + BALL;
        }
        return ball + BALL + " " + strike + STRIKE;
    }
}
