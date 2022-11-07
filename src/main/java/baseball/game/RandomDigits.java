package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.config.GameConstants.BASEBALL_NUMBER_LENGTH;

/**
 * 컴퓨터에 의해서 랜덤하게 만들어진 숫자를 가지고 있는 클래스
 */
public final class RandomDigits extends Digits {
    private RandomDigits() {
        generateRandom();
    }

    /**
     * 랜덤한 숫자의 Digits를 반환하는 정적 팩토리 메서드
     *
     * @return 랜덤한 중복이 없는 3자리 숫자의 Digits
     */
    public static Digits createRandom() {
        return new RandomDigits();
    }

    private void generateRandom() {
        append(Digit.from(Randoms.pickNumberInRange(1, 9)));
        while (size() < BASEBALL_NUMBER_LENGTH) {
            tryToAppend();
        }
    }

    private void tryToAppend() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (!contains(Digit.from(randomNumber))) {
            append(Digit.from(randomNumber));
        }
    }
}
