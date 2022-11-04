package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(guessNumber());
    }
    public static List<Integer> generateNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> guessNumber(){
        String inputNumberStr = Console.readLine();
        List<Integer> inputNumber = stringToIntegerList(inputNumberStr);

        if(validateNumber(inputNumber)){
            return inputNumber;
        }else{
//            return ??;
        }
    }
    public static List<Integer> stringToIntegerList(String inputStr){
        String[] inputStrArr = inputStr.split("");
        List<Integer> inputIntList = new ArrayList<>();
        for (int i = 0; i < inputStrArr.length; i++) {
            int tmp = Integer.parseInt(inputStrArr[i]);
            inputIntList.add(tmp);
        }
        return inputIntList;
    }
    public static boolean validateNumber(List<Integer> inputNumber){
        //length check
        if (inputNumber.size() == 3) {
            return true;
        }

        //same check
        if (inputNumber.size() == inputNumber.stream().distinct().count()) {
            return true;
        }

        //number only check
        String regExp = "^[1-9]+$";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String st = Integer.toString(inputNumber.get(i));
            sb.append(st);
        }
        String s = sb.toString();
        if (s.matches(regExp)) {
            return true;
        }

        return false;
    }

}
