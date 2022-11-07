package baseball;

import java.lang.IllegalArgumentException;
import java.util.List;
import java.util.function.Predicate;

public class Exception {

    protected void chkUserGuessInputValid(List<Integer> input){
        if(input.size() != 3) {
            throw new IllegalArgumentException("세자리 수를 입력하세요.");
        }

        int filterDuplicate = (int) input.stream()
                .distinct()
                .count();

        if(filterDuplicate != 3){
            throw new IllegalArgumentException("서로 다른 세자리 수를 입력하세요.");
        }

        int filterType = (int) input.stream()
                .filter(inputData -> (inputData.getClass().getName().equals("java.lang.Integer")))
                .count();

        if(filterType != 3){
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    protected void chkUserTerminateInputValid(Integer input){
        if(!(input.equals(1) || input.equals(2))){
            throw new IllegalArgumentException("1,2 가 아닌 수를 입력하였습니다.");
        }
        if(!(input.getClass().getName().equals("java.lang.Integer"))){
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }
}
