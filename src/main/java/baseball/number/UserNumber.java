package baseball.number;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {
    private String userNumber;
    private List<Integer> userNumberList;

    public UserNumber(){
        userNumberList = new ArrayList<>(3);
    }

    public List<Integer> inputUserNumber(){
        userNumber = Console.readLine();
        return stringToList(userNumber);

    }

    public List<Integer> stringToList(String userNumber){
        userNumberList = Arrays.stream(userNumber.split("")).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        return userNumberList;
    }
}
