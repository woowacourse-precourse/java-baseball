package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import static baseball.Const.WRONG_INPUT;

public class Ball {
    private Integer number;
    private List<Integer> randomNumberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public Ball() { // Default 생성자
    }

    public Ball(int number) {
        if (!validate(number)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }

        this.number = number;
    }

    public boolean validate(int number) {
        char numberToChar = (char) (number + '0');
        System.out.println(numberToChar);

        if ('1' <= numberToChar && numberToChar <= '9') {
            return true;
        }

        return false;
    }

    public void generate() {
        this.number = Randoms.pickNumberInList(randomNumberList);
        System.out.println(this.number);
    }

    public Integer getNumber() {
        return this.number;
    }
}
