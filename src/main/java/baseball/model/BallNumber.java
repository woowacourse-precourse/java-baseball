package baseball.model;

import java.util.*;

import static baseball.constant.ConstantValue.BASEBALL_NUMBER_SIZE;

public class BallNumber {
    private final List<Integer> ballNumbers;

    public BallNumber(List<Integer> ballNumbers){
        this.ballNumbers = ballNumbers;
    }

    private List<Integer> getBallNumbers(){
        return Collections.unmodifiableList(ballNumbers);
    }

    private void validationSize(List<Integer> ballNumbers){
        if(ballNumbers.size() != BASEBALL_NUMBER_SIZE){
            throw new IllegalArgumentException("공의 사이즈가 3이 아닙니다.");
        }
    }

    private void validationDuplicate(List<Integer> ballNumbers){
        Set<Integer> nonduplicateNumbers = new HashSet<>(ballNumbers);
        if(nonduplicateNumbers.size() != BASEBALL_NUMBER_SIZE){
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }
}
