package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Computer {
    private final List<Integer> randomNumbers = new ArrayList<>(Collections.emptyList());

    public Computer() {
        inputRandomNumbers();
    }
    /**
     * 리스트에 숫자를 추가한다.
     *
     * @param number 숫자
     */
    private void addRandomNumberByList(int number) {
        if (canInputNumber(number)) {
            randomNumbers.add(number);
        }
    }

    /**
     * 숫자를 추가할수 있는가
     * @param number    숫자
     * @return  숫자를 추가할수 있으면 ture
     */
    private boolean canInputNumber(int number) {
        return !isZeroNumber(number) && !hasNumberByList(number);
    }

    /**
     * 랜덤 숫자를 구한다.
     *
     * @return 랜덤 숫자
     */
    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    /**
     * 리스트에 해당 숫자가 있는지 확인한다.
     *
     * @param number 숫자
     * @return 리스트에 해당 숫자가 있으면 ture
     */
    private boolean hasNumberByList(int number) {
        return randomNumbers.contains(number);
    }

    /**
     * 랜덤 숫자들을 구한다.
     */
    private void inputRandomNumbers() {
        while ((randomNumbers.size() != 3)) {
            addRandomNumberByList(createRandomNumber());
        }
    }

    /**
     * 숫자가 0인지 판별
     * @param number 숫자
     * @return 숫자가 0이면 ture
     */
    private boolean isZeroNumber(int number) {
        return number == 0;
    }
}
