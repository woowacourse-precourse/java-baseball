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

    int ballCount(String userInput, List<Integer> computerMadeNumbers){
        int ballCount = 0;
        for(int numberIndex = 0; numberIndex < gameCount; numberIndex++){
            int userValue = Integer.parseInt(userInput.substring(numberIndex,numberIndex+1));
            boolean isNotStrike = !(userValue == computerMadeNumbers.get(numberIndex));
            if(isNotStrike && computerMadeNumbers.contains(userValue)){
                ballCount++;
            }
        }
        return ballCount;
    }
}
