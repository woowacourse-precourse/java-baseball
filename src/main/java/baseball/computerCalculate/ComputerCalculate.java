package baseball.computerCalculate;

import java.util.List;

public class ComputerCalculate {
    final int gameCount = 3;

    int strikeCount(String userInput, List<Integer> computerMadeNumbers){
        int strikeCount = 0;
        for(int numbersIndex = 0; numbersIndex < gameCount; numbersIndex++){
            int userValue = Integer.parseInt(userInput.substring(numbersIndex,numbersIndex+1));
            if(userValue == computerMadeNumbers.get(numbersIndex)){
                strikeCount++;
            }
        }
        return strikeCount;
    }


}
