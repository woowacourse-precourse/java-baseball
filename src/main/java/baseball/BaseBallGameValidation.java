package baseball;

import java.util.Arrays;
import java.util.regex.Pattern;

import static baseball.Application.INT_SIZE;

public class BaseBallGameValidation implements Validation{
    @Override
    public void validateInputCase(String[] inputSplits){
        if(inputSplits.length != INT_SIZE) throw new IllegalArgumentException();
        if(Pattern.matches("[1-9]", Arrays.toString(inputSplits))) throw new IllegalArgumentException();
    }


    @Override
    public void validateDuplicateNumber(String[] inputSplits){
        String input = Arrays.toString(inputSplits);

        for(int i = 0 ; i < inputSplits.length ; i++){
            if(input.indexOf(inputSplits[i]) != input.lastIndexOf(inputSplits[i])) throw new IllegalArgumentException();
        }
    }
}
