package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {

    NumberVO numberVO = new NumberVO();

    public List<Integer> inputUserNumber() {

        String userNumber = Console.readLine(); // 입력 받기
        List<Integer> userNumberList = userNumberConvertToList(userNumber); // 자릿수로 나눈 리스트로 변환
        System.out.println(userNumberList);
        return userNumberList;
    }

    // 숫자 하나씩 나누어서 리스트에 보관
    public List<Integer> userNumberConvertToList(String userNumber) {
        List<Integer> userNumberList = Stream.of(userNumber.split("")).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        return userNumberList;
    }

    // userNumber와 randomNumber의 교집합 검사
    public List<Integer> checkContains(List<Integer> userNumberList, List<Integer> radomNumberList) {
        return radomNumberList.stream().filter(userNumberList::contains).collect(Collectors.toList());
    }

    public void compareGameCount(List<Integer> userNumberList, List<Integer> radomNumberList) {
        System.out.println("교집합:" + checkContains(userNumberList, radomNumberList) + ":");
    }
}
