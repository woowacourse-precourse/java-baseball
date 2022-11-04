package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    private static void setInput(){
        List<Integer> computerNumberGroup = setComputerNumberGroup();
    }

    private static List<Integer> setComputerNumberGroup(){
        List<Integer> computerNumberGroup = new ArrayList<>();
        while(computerNumberGroup.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumberGroup.contains(randomNumber)){
                computerNumberGroup.add(randomNumber);
            }
        }
        return computerNumberGroup;
    }

    private static String setMyNumberGroupByString() {
        String inputNumberString = Console.readLine();
        return inputNumberString;
    }

    private static void isValidMyInput(String inputNumberString){
        if(!isValidLength(inputNumberString)){
            throw new IllegalArgumentException("세자리가 아님");
        }
        if(!isNumeric(inputNumberString)){
            throw new IllegalArgumentException("숫자가 아닌 문자 입력");
        }
    }

    private static boolean isValidLength(String inputNumberString){
        if(inputNumberString.length()==3){
            return true;
        } else
            return false;
    }

    private static boolean isNumeric(String inputNumberString){
        try{
            Double.parseDouble(inputNumberString);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
