package baseball.game;

import static baseball.config.GameConstants.BASEBALL_NUMBER_LENGTH;

/**
 * 컴퓨터에 의해서 랜덤하게 만들어진 숫자를 가지고 있는 클래스
 */
final class RandomDigits extends Digits {
    private final RandomInRange random;

    private RandomDigits(RandomInRange random) {
        this.random = random;
        generateRandom();
    }

    /**
     * 랜덤한 숫자의 Digits를 반환하는 정적 팩토리 메서드
     *
     * @return 랜덤한 중복이 없는 3자리 숫자의 Digits
     */
    public static Digits createRandom(RandomInRange random) {
        return new RandomDigits(random);
    }

    private void generateRandom() {
        //100의 자리에서는 0이 올 수 없기에 미리 1부터 9까지 추가해둠
        append(random.pickRandomInRange(1, 9));
        while (isSmallerThanLimit()) {
            tryToAppend();
        }
    }

    private boolean isSmallerThanLimit() {
        return size() < BASEBALL_NUMBER_LENGTH;
    }

    private void tryToAppend() {
        //10,1의 자리에서는 0이 올 수 있기에 0부터 9까지 뽑음
        Digit randomNumber = random.pickRandomInRange(0, 9);
        if (!contains((randomNumber))) {
            append(randomNumber);
        }
    }
}
