package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
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

    private void validateUserInput(String userInput, boolean gameover){
        if(gameover){
            if(!Objects.equals(userInput,"1") && !Objects.equals(userInput,"2")){
                throw new IllegalArgumentException("userInput should be 1 or 2.");
            }
        } else{
            if(!is3DigitNumberWithoutZero(userInput) && hasUniqueCharacter(userInput)){
                throw new IllegalArgumentException("userInput should be 3 digit number.");
            }
        }
    }
    private List<Integer> createComputerNumbers(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
