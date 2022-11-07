package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBallsGenerator {
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 9;
    private int maxLen;

    public ComputerBallsGenerator() {
        this(3);
    }

    public ComputerBallsGenerator(int maxLen) {
        this.maxLen = maxLen;
    }

    public String ballsGenerator() {
        return getRandomNumbers();
    }
    public String getRandomNumbers() {
        String randomNumbers = "";
        String res = setRandomNumbers(randomNumbers);
        return res;
    }
    public String setRandomNumbers(String randomNumbers) {
        int randomNumber;

        while (randomNumbers.length() != maxLen) {
             randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!randomNumbers.contains(String.valueOf(randomNumber))) {
                randomNumbers += randomNumber + "";
            }
        }

        return randomNumbers;
    }
    // test에서 사용하기 위한 Public 메서드
    public int getBallsLength() {
        return maxLen;
    }
}
