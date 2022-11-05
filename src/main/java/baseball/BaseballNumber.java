package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.utils.Util;

public class BaseballNumber {
    private List<Integer> listNumber;
    private final int GAME_DIGIT = 3;
    // 나중에 GAME_DIGIT, setRandomValue는 상황 체크 후에 BaseballManager에게 책임 위임
    BaseballNumber(int number) {
        this.listNumber = Util.splitDigitsIntoList(number);
    }

    public int getNumberAt(int index) {
        return listNumber.get(index);
    }

    public void setRandomValue() {
        this.listNumber = Util.splitDigitsIntoList(
                RandomNumGenerator.makeRandomNumWithNDigits(GAME_DIGIT)
        );
    }
}
