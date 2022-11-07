package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGame {
    public static final int NUM_LENGTH = 3;

    public static List<Integer> ComputerNumGenerator(){
        List<Integer> num = new ArrayList<>();
        while (num.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }
        return num;
    }


    public static List<Integer> userInputValidator(String input) throws IllegalArgumentException{
        if(isThreelen(input) && isNotDuplicated(input) && isOneNineInt(input)){
            List<Integer> num = new ArrayList<>();
            for(int i=0; i<NUM_LENGTH; i++){
                num.add(input.charAt(i)-'0');
            }
            return num;
        }
        else
            throw new IllegalArgumentException();
    }


    public static boolean isThreelen(String input){
        return input.length() == 3;
    }

    public static boolean isNotDuplicated(String input){
        ArrayList<String> listInput = new ArrayList<>(Arrays.asList(input.split("")));
        Set<String> inputSet = new HashSet<>(listInput);
        return inputSet.size() == listInput.size();
    }


    public static boolean isOneNineInt(String input){
        for(int i=0; i < input.length(); i++){
            char n = input.charAt(i);
            if(n == '0' || !Character.isDigit(n))
                return false;
        }
        return true;
    }


    public static List<Integer> HintProvider(List<Integer> computerNum, List<Integer> userNum){
        List<Integer> result = new ArrayList<>();
        result.add(ballCount(computerNum,userNum));
        result.add(strikeCount(computerNum,userNum));
        return result;
    }


    public static int ballCount(List<Integer> computerNum, List<Integer> userNum) {
        int count = 0;

        for(int i=0; i<NUM_LENGTH; i++){
            if (computerNum.get(i) != userNum.get(i) && computerNum.contains(userNum.get(i)))
                count++;
        }

        return count;
    }


    public static int strikeCount(List<Integer> computerNum, List<Integer> userNum) {
        int count = 0;

        for(int i=0; i<NUM_LENGTH; i++){
            if (computerNum.get(i) == userNum.get(i))
                count++;
        }

        return count;
    }

}
