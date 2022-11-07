package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> generateRandomNumber() {
        List<Integer> generatedNumber = new ArrayList<>();
        while (generatedNumber.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumber.contains(randomNumber)){
                generatedNumber.add(randomNumber);
            }
        }
        return generatedNumber;
    }

    public static List<Integer> checkStrike (List<Integer> generatedNumber, List<Integer> userNumber){
        List<Integer> standardNumber = new ArrayList<>(generatedNumber);
        List<Integer> inputNumber = new ArrayList<>(userNumber);
        List<Integer> strikeIndex = new ArrayList<>();
        for(int listIndex=0; listIndex < 3; listIndex ++){
            if(standardNumber.get(listIndex).equals(inputNumber.get(listIndex))){
                strikeIndex.add(listIndex);
            }
        }
        return strikeIndex;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
