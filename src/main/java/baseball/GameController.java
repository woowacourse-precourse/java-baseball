package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {

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

    // userNumberList와 randomNumberList의 교집합 검사
    public int checkIntersection(List<Integer> userNumberList, List<Integer> randomNumberList) {
        return randomNumberList.stream().filter(userNumberList::contains).collect(Collectors.toList()).size();
    }

    public void checkGameResult(List<Integer> userNumberList, List<Integer> randomNumberList, int ballCount) {

        if (ballCount == 0) {
            ShowMessage.showNotMatchWord(); // 낫싱
        } else {
            calculateGameCount(userNumberList, randomNumberList, ballCount);
        }
    }

    public void calculateGameCount(List<Integer> userNumberList, List<Integer> randomNumberList, int ballCount) {

        ShowMessage showMessage = new ShowMessage();
        int answerCount = showMessage.getAnswerCount();
        int strikeCount = 0;

        System.out.println("입력값:" + userNumberList + ":");
        System.out.println("난수:" + randomNumberList + ":");

        for (int i = 0; i < answerCount; i++) {
            System.out.println("스트라이크 몇 개인지 검사");
            if (userNumberList.get(i) == randomNumberList.get(i)) {
                System.out.println("스트라이크 발견");
                strikeCount++;
            }
        }
        ballCount -= strikeCount;
        System.out.println("볼:" + ballCount + ":");
        System.out.println("스트라이크:" + strikeCount + ":");
    }

}
