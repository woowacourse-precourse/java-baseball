package baseball;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pitches {
    private final List<Integer> pitches;
    public Pitches(String userInput){
        validateUserInput(userInput);
        pitches = userInput.chars()
                .mapToObj(ch -> ch - '0')
                .collect(Collectors.toList());
    }
    private boolean isNumberWithoutZero(String str){
        if(str == null || str.isEmpty())
            return false;
        long numOfDigit = str.chars()
                .mapToObj(ch -> (char)ch)
                .filter(ch -> Character.isDigit(ch) && !Objects.equals(ch,'0'))
                .count();
        return numOfDigit == str.length();
    }
    private boolean is3DigitNumberWithoutZero(String str){
        return isNumberWithoutZero(str) && str.length() == 3;
    }
    private boolean hasUniqueCharacter(String str){
        if(str == null || str.isEmpty())
            return false;
        long numOfUniqueCharacter = str.chars()
                .distinct()
                .count();
        return numOfUniqueCharacter == str.length();
    }
    private void validateUserInput(String userInput){
        if(!is3DigitNumberWithoutZero(userInput) || !hasUniqueCharacter(userInput)){
            throw new IllegalArgumentException("userInput should be 3 distinct digit number.");
        }
    }
    public int numOfStrike(Pitches computer){
        return (int) IntStream.range(0, 3)
                .filter(i -> Objects.equals(pitches.get(i), computer.pitches.get(i)))
                .count();
    }
    public int numOfBall(Pitches computer){
        return (int)IntStream.range(0, 3)
                .filter(i -> !Objects.equals(pitches.get(i), computer.pitches.get(i))
                        && computer.pitches.contains(pitches.get(i)))
                .count();
    }
}
