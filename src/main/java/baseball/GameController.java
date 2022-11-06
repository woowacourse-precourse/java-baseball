package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {

    NumberVO numberVO = new NumberVO();

    public void inputUserNumber() {

        String userNumber = Console.readLine(); // 입력 받기
        List<Integer> userNumberList = userNumberConvertToList(userNumber); // 자릿수로 나눈 리스트로 변환
        numberVO.setUserNumber(userNumberList);
        System.out.println("사용자 값:"+numberVO.getUserNumber()+":");
    }

    // 숫자 하나씩 나누어서 리스트에 보관
    public List<Integer> userNumberConvertToList(String userNumber) {
        List<Integer> userNumberList = Stream.of(userNumber.split("")).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        return userNumberList;
    }

    // userNumber와 randomNumber의 교집합 검사
    public List<Integer> checkContains(){

        List<Integer> userNumber = numberVO.getUserNumber();
        List<Integer> randomNumber = numberVO.getRandomNumber();

        return randomNumber.stream().filter(userNumber::contains).collect(Collectors.toList());
    }

    public void compareGameCount(){



    }
}
