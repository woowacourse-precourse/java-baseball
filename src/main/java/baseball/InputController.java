package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputController {

    public List<Integer> gameUserInput(){
        List<Integer> userNumberList = inputConvert(); // 사용자 입력
        return userNumberList;
    }

    public List<Integer> inputConvert() {
        String userNumber = getInput();
        List<Integer> userNumberList = userNumberConvertToList(userNumber); // 자릿수로 나눈 리스트로 변환
        return userNumberList;
    }

    public String getInput(){
        ShowMessage.showInputNumber(); // 숫자 입력 메세지 출력
        String userNumber = Console.readLine(); // 입력 받기
        return userNumber;
    }

    // 숫자 하나씩 나누어서 리스트에 보관
    public List<Integer> userNumberConvertToList(String userNumber) {
        List<Integer> userNumberList = Stream.of(userNumber.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return userNumberList;
    }

//    public String inputException(String userNumber){
//        Exception exception = new Exception();
//        userNumber = getInput(); // 입력 받기
//        exception.numberException(userNumber);
//        System.out.println("inputException");
//        return userNumber;
//    }

}
