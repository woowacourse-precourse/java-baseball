package baseball.number;

import baseball.excpetion.NumberException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {
    private String userNumber;
    private List<Integer> userNumberList;
    private NumberException numberException;
    public UserNumber(){
        userNumberList = new ArrayList<>();
        numberException = new NumberException();
    }

    public List<Integer> inputUserNumber(){
        userNumber = Console.readLine();
        numberException.validContainLetter(userNumber);
        numberException.validDuplicateNumber(userNumber);
        numberException.validContainLetter(userNumber);
        return stringToList(userNumber);

    }

    public List<Integer> stringToList(String userNumber){
        userNumberList = Arrays.stream(userNumber.split("")).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        return userNumberList;
    }
}
