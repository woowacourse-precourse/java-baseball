package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputController {

    public String getInput(){
        String inputNumber = Console.readLine(); // 입력 받기
        return inputNumber;
    }

    // 숫자 하나씩 나누어서 리스트에 보관
    public List<Integer> userNumberConvertToList(String userNumber) {
        List<Integer> userNumberList = Stream.of(userNumber.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return userNumberList;
    }

}
