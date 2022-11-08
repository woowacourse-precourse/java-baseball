package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤으로 숫자를 정하고 입력한 숫자에 대한 힌트를 전달해주는 컴퓨터 클래스
 */
public class Computer {
    private List<Integer> computerNumbers;
    private Hint hint;

    public void createRandomNumber() {
        computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public Hint getHint(String number) {
        hint = new Hint();

        for (int index = 0; index < 3; index++) {
            countHint(index, number.charAt(index) - '0');
        }

        return hint;
    }

    /**
     * 각 자리수를 비교하며 ball과 strike를 증가시키는 메서드
     */
    private void countHint(int index, int number) {
        if (isContainsNumber(number)) {
            int computerIndex = computerNumbers.indexOf(number);

            if (isEqualIndex(computerIndex, index)) {
                hint.increaseStrike();
            } else {
                hint.increaseBall();
            }
        }
    }

    private boolean isContainsNumber(int number) {
        if (computerNumbers.contains(number)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEqualIndex(int computerIndex, int index) {
        if (computerIndex == index) {
            return true;
        } else {
            return false;
        }
    }

}
