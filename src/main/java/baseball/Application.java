package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.Constants.*;
import static baseball.View.*;

public class Application {
    public static void main(String[] args) {
        printStartMsg();
        playGame();
    }

    private static String getRandomNumber(){
        List<String> computer = new ArrayList<>();
        while (computer.size() < NUM_OF_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
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
        int[] results = new int[2];
        for(int iter = 0; iter < NUM_OF_DIGIT; iter++){
            if(computer.charAt(iter) == user.charAt(iter)){
                results[STRIKE_IDX]++;
                continue;
            }
            if(computer.contains(String.valueOf(user.charAt(iter)))){
                results[BALL_IDX]++;
            }
        }
        return results;
    }

    private static void validateNum(String userInput) throws IllegalArgumentException {
        if(userInput.length() != NUM_OF_DIGIT)
            throw new IllegalArgumentException("3자리 수를 입력해주세요");
        if(!isNumeric(userInput))
            throw new IllegalArgumentException("1과 9사이의 숫자를 입력해주세요");
        if(isDuplicate(userInput))
            throw new IllegalArgumentException("중복이 없는 숫자를 입력해주세요");
    }

    public static boolean isNumeric(String input) {
       for(int iter = 0; iter < NUM_OF_DIGIT; iter++){
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
        for(int iter = 0; iter < NUM_OF_DIGIT; iter++){
            list.add(Integer.parseInt(strList[iter]));
        }
        Set<Integer> set = new HashSet<>(list);
        if(list.size() != set.size()){
            return true;
        }
        return false;
    }
}
