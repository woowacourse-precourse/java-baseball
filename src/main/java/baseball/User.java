package baseball;


import camp.nextstep.edu.missionutils.Console;
import java.util.*;


public class User {
    public static List<Integer> userNumbers = new ArrayList<>();

    public static List<Integer> inputGameNumber(){

        String StringUserInput = Console.readLine();

        String[] arrayInput = StringUserInput.split("");

        for(int i=0; i<StringUserInput.length();i++){
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }

        return userNumbers;
    }

    public static void validateUserNum(){

        if(userNumbers.size() != 3){
            throw new IllegalArgumentException("올바른 숫자가 아닙니다.");
        }
        // 사이즈가 3이 아닌 경우

        if(userNumbers.contains(0)){
            throw new IllegalArgumentException("올바른 숫자가 아닙니다.");
        }
        // 0을 포함한 경우

        for(int i =0; i< userNumbers.size(); i++){
            if(Collections.frequency(userNumbers, userNumbers.get(i)) != 1){
                throw  new IllegalArgumentException("올바른 숫자가 아닙니다. 같은 숫자가 존재합니다.");
            }
        }
        // 중복 숫자를 입력한 경우
    }
}

