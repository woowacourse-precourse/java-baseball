package baseball;

import baseball.dto.Computer;
import baseball.dto.GameScore;
import baseball.dto.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompareNumber {

    // 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교하기 위한 메소드
    public GameScore compareNumber(User user, Computer computer) {
        List<List<Integer>> compareResult = new ArrayList<>();
        int[] score = {0, 0};

        for (int i = 0; i < 3; i++) {
            preMakeCompareList(i, compareResult, user, computer);
        }

        for (List<Integer> result : compareResult) {
            plusStrike(result, score);
            plusBall(result, score);
        }

        return new GameScore(score[0], score[1]);
    }

    // 이중 반복문으로 인해 객체지향 생활 체조 원칙 1번이 깨지는 것을 방지하기 위해 분리한 메소드
    private void preMakeCompareList (int index1, List<List<Integer>> compareResult, User user, Computer computer) {
        for (int index2 = 0; index2 < 3; index2++) {
            int[] indexArray = {index1, index2};
            inspectListSize(indexArray, compareResult, user, computer);
        }
    }

    // makeCompareList 메소드에서 전달받은 List가 유효한 메소드일 경우 List<Integer>형 List compareResult에 추가
    private void inspectListSize(int[] indexArray, List<List<Integer>> compareResult, User user, Computer computer) {
        if (makeCompareList(indexArray[0], indexArray[1], user, computer).size() > 0) {
            compareResult.add(makeCompareList(indexArray[0], indexArray[1], user, computer));
        }
    }

    // 사용자와 컴퓨터의 숫자 List에서 같은 숫자가 존재하면 그것들의 인덱스를 Integer형 리스트에 저장 후 반환하는 메소드
    private List<Integer> makeCompareList(int index1, int index2, User user, Computer computer) {
        List<Integer> result = new ArrayList<>();

        if (Objects.equals(user.getUsersNumber().get(index1), computer.getComputerNumber().get(index2))) {
            result.add(index1);
            result.add(index2);
        }

        return result;
    }

    // List<Integer>형 List compareResult의 항목에 존재하는 값이 서로 같을 경우 스트라이크 이므로 스트라이크를 1 추가
    private void plusStrike(List<Integer> result, int[] score) {
        if (Objects.equals(result.get(0), result.get(1))) {
            score[0] += 1;
        }
    }

    // List<Integer>형 List compareResult의 항목에 존재하는 값이 서로 다를 경우 볼 이므로 볼를 1 추가
    private void plusBall(List<Integer> result, int[] score) {
        if (!(Objects.equals(result.get(0), result.get(1)))) {
            score[1] += 1;
        }
    }

}
