package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {

    private List<Integer> digits;

    public UserNumber(){

    }

    public Integer getDigit(int index){
        return digits.get(index);
    }

    public void setDigits(String input){
        this.digits = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
