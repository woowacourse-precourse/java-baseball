package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.View.*;

public class Application {
    public static void main(String[] args) {
        printStartMsg();
        playGame();
    }

    private static String getRandomNumber(){
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(String.valueOf(randomNumber));
            }
        }
        return String.join("",computer);
    }

    public static void playGame(){
        printInputMsg();
        String computer = getRandomNumber();
        String userInput = Console.readLine();
        validateNum(userInput);
        compare(computer, userInput);
    }

    public static int[] compare(String computer, String user) {
        int[] results = {0, 0};
        for(int iter = 0; iter < 3; iter++){
            if(computer.charAt(iter) == user.charAt(iter)){
                results[0]++;
                continue;
            }
            if(computer.contains(String.valueOf(user.charAt(iter)))){
                results[1]++;
            }
        }
        return results;
    }

    private static void validateNum(String userInput) throws IllegalArgumentException {
        if(userInput.length() != 3)
            throw new IllegalArgumentException("3자리 수를 입력해주세요");
        if(!isNumeric(userInput))
            throw new IllegalArgumentException("1과 9사이의 숫자를 입력해주세요");
        if(isDuplicate(userInput))
            throw new IllegalArgumentException("중복이 없는 숫자를 입력해주세요");
    }

    public static boolean isNumeric(String input) {
       for(int iter = 0; iter < input.length(); iter++){
           char c = input.charAt(iter);
           if(c < '1' || c > '9'){
               return false;
           }
       }
       return true;
    }

    public static boolean isDuplicate(String input) {
        List<Integer> list = new ArrayList<>();
        String [] strList = input.split("");
        for(int iter = 0; iter < input.length(); iter++){
            list.add(Integer.parseInt(strList[iter]));
        }
        Set<Integer> set = new HashSet<>(list);
        if(list.size() != set.size()){
            return true;
        }
        return false;
    }
}
