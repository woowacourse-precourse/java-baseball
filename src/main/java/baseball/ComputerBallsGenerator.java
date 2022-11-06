package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBallsGenerator {
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 9;
    private int maxLen;
    private String balls;

    public ComputerBallsGenerator() {
        this(3);
    }

    public ComputerBallsGenerator(int maxLen) {
        this.maxLen = maxLen;
    }

    public void ballsGenerator() {
        this.balls = getRandomNumbers();
    }
    public String getRandomNumbers() {
        String randomNumbers = new String();
        return setRandomNumbers(randomNumbers);
    }
    public String setRandomNumbers(String randomNumbers) {
        int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        if (!randomNumbers.contains(randomNumber+"")) {
            randomNumbers += randomNumber + "";
        }
        if (randomNumbers.length() != maxLen) {
            setRandomNumbers(randomNumbers);
        }
        return randomNumbers;
    }
    // test에서 사용하기 위한 Public 메서드
    public int getBallsLength() {
        return maxLen;
    }
}
