package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

    public static int checkBall (List<Integer> generatedNumber, List<Integer> userNumber, List<Integer> indexOfStrike){
        List<Integer> standardNumber = new ArrayList<>(generatedNumber);
        List<Integer> inputNumber = new ArrayList<>(userNumber);
        List<Integer> strikeIndex = new ArrayList<>(indexOfStrike);
        int count = 0;
        for(int listIndex=0; listIndex < 3; listIndex++){
            if(standardNumber.contains(inputNumber.get(listIndex))){
                count += 1;
            }
            if(strikeIndex.contains(listIndex)){
                count -= 1;
            }
        }
        return count;
    }

    public static List<Integer> stringToList (String input){
        int integerInput = Integer.parseInt(input);
        List<Integer> listInput = new ArrayList<>();
        while(integerInput > 0){
            listInput.add(integerInput % 10);
            integerInput /= 10;
        }
        Collections.reverse(listInput);
        return listInput;
    }

    public static void main(String[] args) {

    }
}
