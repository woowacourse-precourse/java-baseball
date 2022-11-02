package baseball.inputs;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameInputOutput {
    public List<Integer> computerMadeNumbers(){
        List<Integer> numberMadeByComputer = new ArrayList<>();
        while(numberMadeByComputer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!numberMadeByComputer.contains(randomNumber)){
                numberMadeByComputer.add(randomNumber);
            }
        }

        return numberMadeByComputer;
    }
    public String userPlayingInput(){
        String userInput = Console.readLine();

        boolean isInputLengthThree = (userInput.length() != 3);
        boolean haveSameNumberInInput = haveSameNumbers(userInput);
        if(isInputLengthThree || haveSameNumberInInput){
            throw new IllegalArgumentException("숫자의 길이가 3이 아니거나, 입력에 두개 이상의 같은 숫자를 포함하고 있습니다.");
        }

        return userInput;
    }

    boolean haveSameNumbers(String input){
        Set<Integer> numberSet = new HashSet<>();
        for(int stringIndex = 0; stringIndex < input.length(); stringIndex++){
            numberSet.add(Integer.parseInt(input.substring(stringIndex,stringIndex+1)));
        }

        return numberSet.size() == 3;
    }
}
