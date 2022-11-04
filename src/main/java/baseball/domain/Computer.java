package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    String numbers = "";

    public Computer() {
        setNumbers();
    }

    private void setNumbers() {
        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            numbers += number;
        }
    }

    public String getNumbers() {
        return numbers;
    }
}
