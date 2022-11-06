package baseball.refree;

import java.util.List;

public class Refree {

    private static final int DEFAULT_INT_ZERO = 0;
    private static final String DEFAULT_STRING_BLANK = "";

    public boolean compareToUserInput(String randomNumber,String input){
        int strike = DEFAULT_INT_ZERO;
        int ball = DEFAULT_INT_ZERO;
        int nothing = DEFAULT_INT_ZERO;

        String[] inputList = input.split(DEFAULT_STRING_BLANK);
        for (int i = 0; i < inputList.length; i++) {
            if(randomNumber.contains(input) && randomNumber.indexOf(i) == i){
                strike++;
            }
            else if(randomNumber.contains(input) && randomNumber.indexOf(i) != i){
                ball++;
            }
            else{
                nothing++;
            }
        }
        System.out.println("strike : " + strike + "ball : " + ball + "nothing : " + nothing );
    }
}
