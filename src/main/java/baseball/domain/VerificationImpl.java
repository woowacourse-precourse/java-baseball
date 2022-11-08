package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VerificationImpl implements Verification{

    @Override
    public void onlyNumberVerification(String input) {
        if(input.matches("^[1-9]*$"))
            return;

        throw new IllegalArgumentException();
    }

    @Override
    public void lengthVerification(String input) {
        if(input.length() == 3)
            return;

        throw new IllegalArgumentException();
    }

    @Override
    public void uniqueNumberVerification(String input) {
        Set<String> inputSet = new HashSet<>(Arrays.asList(input.split("")));
        if((input.length() - inputSet.size() == 0))
            return;

        throw new IllegalArgumentException();
    }

    @Override
    public void rangeVerification(String input) {

        for(int i=0;i<input.length();i++){
            int number = characterToInt(input.charAt(i));
            rangeVerifyCheck(number);
        }
    }
    private int characterToInt(Character ch){
        return Character.getNumericValue(ch);
    }

    private void rangeVerifyCheck(int number){
        if(number <1 || number >9)
            throw new IllegalArgumentException();
    }
}
