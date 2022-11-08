package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Integer> createGuessNumber(){
        String guessNumberString = readLine();

        List<Integer> guessNumber = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            guessNumber.add(guessNumberString.charAt(i) - '0');
        }

        return guessNumber;
    }
}
