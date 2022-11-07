package baseball.model;

import baseball.constant.Constant;
import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private Ball computerNumber;
    private final int NUM_LENGTH = 3;
    private final int START_NUM = 1;
    private final int END_NUM = 9;

    public Computer() {
    }

    public void setComputerRandomNumber() {
        String randomNumber = createRandomNumberInLength(NUM_LENGTH);
        this.computerNumber = new Ball(randomNumber);
    }

    public Ball getComputerRandomNumber() {
        return computerNumber;
    }

    private String createRandomNumberInLength(int length) {
        List<String> stringList = new ArrayList<>();
        while (stringList.size() < length) {
            String number = createRandomNumber();
            addUniqueString(stringList, number);
        }
        return String.join(Constant.EMPTY_STRING, stringList);
    }

    private String createRandomNumber() {
        int number = Randoms.pickNumberInRange(START_NUM, END_NUM);
        return String.valueOf(number);
    }

    private void addUniqueString(List<String> stringList, String string) {
        if (!stringList.contains(string)) {
            stringList.add(string);
        }
    }
}
