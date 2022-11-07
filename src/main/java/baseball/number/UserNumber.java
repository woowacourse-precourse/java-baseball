package baseball.number;

import baseball.excpetion.NumberException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {
    private NumberException numberException;

    public UserNumber(){
        numberException = new NumberException();

    }

    public List<Integer> inputUserNumber(){
        String userNumber = Console.readLine();
        numberException.validNumberLength(userNumber);
        numberException.validDuplicateNumber(userNumber);
        numberException.validContainLetter(userNumber);
        return stringToList(userNumber);

    }

    public List<Integer> stringToList(String userNumber){
        List<Integer> userNumberList = new ArrayList<>();
        for(int i=0; i<userNumber.length(); i++){
            userNumberList.add(Integer.parseInt(String.valueOf(userNumber.charAt(i))));
        }
        return userNumberList;
    }
}
