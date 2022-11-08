package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Integer> createGuessNumber(){
        String guessNumberString = readLine();

        exceptionHandler(guessNumberString);

        List<Integer> guessNumber = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            guessNumber.add(guessNumberString.charAt(i) - '0');
        }

        return guessNumber;
    }

    private void exceptionHandler(String number){
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();

        if(!isValidSize(number)
                || !isValidScope(number)
                || !isDifferentNumber(number)){
            throw illegalArgumentException;
        }
    }

    private boolean isValidSize(String number){
        return number.length() == 3;
    }

    private boolean isValidScope(String number){
        for(int i = 0; i < 3; i++){
            if(!(number.charAt(i) >= '1' && number.charAt(i) <= '9')){
                return false;
            }
        }

        return true;
    }

    private boolean isDifferentNumber(String number){
        return number.charAt(0) != number.charAt(1)
                && number.charAt(0) != number.charAt(2)
                && number.charAt(1) != number.charAt(2);
    }
}
