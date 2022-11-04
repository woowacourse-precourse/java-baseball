package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private List<Integer> numbers;
    private int strikeCount;
    private int ballCount;

    public Computer(){
        while (numbers.size() < CNT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
    public List<Integer> getNumbers(){
        return this.numbers;
    }
    public int getStrikeCount(){
        return strikeCount;
    }
    public int getBallCount(){
        return ballCount;
    }

}
