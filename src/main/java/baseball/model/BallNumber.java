package baseball.model;

import java.util.*;

import static baseball.constant.ConstantValue.BASEBALL_NUMBER_SIZE;

public class BallNumber {
    private final List<Integer> ballNumbers;

    public BallNumber(List<Integer> ballNumbers){
        validateSize(ballNumbers);
        validateNaturalNumber(ballNumbers);
        validateDuplicate(ballNumbers);
        this.ballNumbers = ballNumbers;
    }

    public List<Integer> getBallNumbers(){
        return Collections.unmodifiableList(ballNumbers);
    }
    private void validateSize(List<Integer> ballNumbers){
        if(ballNumbers.size() != BASEBALL_NUMBER_SIZE){
            throw new IllegalArgumentException("공의 사이즈가 3이 아닙니다.");
        }
    }

    private void validateNaturalNumber(List<Integer> ballNumbers){
        for(int i = 0; i < BASEBALL_NUMBER_SIZE; i++){
            if(ballNumbers.get(i) < 1 || ballNumbers.get(i) > 9){
                throw new IllegalArgumentException("1~9사이의 숫자가 아닙니다");
            }
        }
    }

    private void validateDuplicate(List<Integer> ballNumbers){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(ballNumbers);
        if(nonDuplicateNumbers.size() != BASEBALL_NUMBER_SIZE){
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }
}
