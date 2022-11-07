package baseball.model;

import static baseball.util.BallCode.*;

import baseball.util.BallCode;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final static int NUMBER_SIZE = 3;
    private final static int MAX_NUMBER = 9;
    private final static int MIN_NUMBER = 1;

    private List<Integer> numbers = new ArrayList<>();

    public void createRandomNumber(){
        numbers.clear();
        while (numbers.size() < NUMBER_SIZE){
            int number = Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
            isListContainNumber(number);
        }
    }

    private void isListContainNumber(Integer number){
        if(!numbers.contains(number))
            numbers.add(number);
    }

    public BallCode getScore(int index, int userScore){
        if(numbers.get(index) == userScore)
            return STRIKE;
        if(numbers.contains(userScore))
            return BALL;
        return NOTHING;
    }
}
