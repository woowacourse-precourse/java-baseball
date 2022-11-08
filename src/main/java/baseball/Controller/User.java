package baseball.Controller;

import baseball.model.Baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    public static final int BASEBALL_LENGTH = 3;
    public static final int ZERO = 0;
    public Baseball getInput(){
        String input = Console.readLine();
        List<Integer> userNumber = mappingToList(input);

        if(!isCorrectForm(userNumber)) {
            throw new IllegalArgumentException(ZERO + "이 아닌 " + BASEBALL_LENGTH + "자리 숫자를 입력해주세요.");
        }
        return new Baseball(userNumber);
    }
    private boolean isCorrectForm(List<Integer> userNumber){
        if(userNumber.size() == BASEBALL_LENGTH && !userNumber.contains(ZERO)){
            return true;
        }
        return false;
    }

    public static List<Integer> mappingToList(String input){
        List<Integer> userNumber = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            int digit = strToInt(input, i);
            userNumber.add(digit);
        }
        return userNumber;
    }

    public static int strToInt(String input, int index){
        char c = input.charAt(index);
        int value = Character.getNumericValue(c);
        return value;
    }
}
