package baseball.computerCalculate;

import baseball.inputs.GameOutput;

import java.util.List;

public class ComputerCalculate {
    final int gameCount = 3;

    public boolean compareUserAndComputer(String userInput, List<Integer> computerMadeNumbers){
        GameOutput output = new GameOutput();
        int strikeCount = strikeCount(userInput,computerMadeNumbers);
        int ballCount = ballCount(userInput,computerMadeNumbers);

        output.printPlayingCount(strikeCount,ballCount);

        return (strikeCount == 3);
    }

    int strikeCount(String userInput, List<Integer> computerMadeNumbers){
        int strikeCount = 0;
        for(int numberIndex = 0; numberIndex < gameCount; numberIndex++){
            int userValue = Integer.parseInt(userInput.substring(numberIndex,numberIndex+1));
            int computersPickNumber = computerMadeNumbers.get(numberIndex);

            if(isStrike(userValue,computersPickNumber)){
                strikeCount++;
            }
        }
        return strikeCount;
    }

    int ballCount(String userInput, List<Integer> computerMadeNumbers){
        int ballCount = 0;
        for(int numberIndex = 0; numberIndex < gameCount; numberIndex++){
            int userValue = Integer.parseInt(userInput.substring(numberIndex,numberIndex+1));
            int computersPickNumber = computerMadeNumbers.get(numberIndex);

            if(isBall(userValue,computersPickNumber,computerMadeNumbers)){
                ballCount++;
            }
        }
        return ballCount;
    }
    boolean isStrike(int userValue, Integer computersPickNumber){
        return userValue == computersPickNumber;
    }

    boolean isBall(int userValue, Integer computersPickNumber, List<Integer> computerMadeNumbers){
        return !isStrike(userValue,computersPickNumber) && computerMadeNumbers.contains(userValue);
    }
}
