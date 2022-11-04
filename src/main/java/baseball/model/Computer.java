package baseball.model;

import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private Ball computerNumber;

    public Computer() {
    }

    public void setComputerRandomNumber() {
        String randomNumber = createRandomNumberInLength(3);
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
        return String.join("", stringList);
    }

    private String createRandomNumber() {
        int number = Randoms.pickNumberInRange(1, 9);
        return String.valueOf(number);
    }

    private void addUniqueString(List<String> stringList, String string) {
        if (!stringList.contains(string)) {
            stringList.add(string);
        }
    }
}
