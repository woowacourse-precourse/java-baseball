package baseball;

import baseball.dto.Computer;
import baseball.dto.GameScore;
import baseball.dto.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompareNumber {
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

    private void preMakeCompareList (int index1, List<List<Integer>> compareResult, User user, Computer computer) {
        for (int index2 = 0; index2 < 3; index2++) {
            int[] indexArray = {index1, index2};
            inspectListSize(indexArray, compareResult, user, computer);
        }
    }

    private void inspectListSize(int[] indexList, List<List<Integer>> compareResult, User user, Computer computer) {
        if (makeCompareList(indexList[0], indexList[1], user, computer).size() > 0) {
            compareResult.add(makeCompareList(indexList[0], indexList[1], user, computer));
        }
    }

    private List<Integer> makeCompareList(int index1, int index2, User user, Computer computer) {
        List<Integer> result = new ArrayList<>();

        if (Objects.equals(user.getUsersNumber().get(index1), computer.getComputerNumber().get(index2))) {
            result.add(index1);
            result.add(index2);
        }

        return result;
    }

    private void plusStrike(List<Integer> result, int[] score) {
        if (Objects.equals(result.get(0), result.get(1))) {
            score[0] += 1;
        }
    }

    private void plusBall(List<Integer> result, int[] score) {
        if (!(Objects.equals(result.get(0), result.get(1)))) {
            score[1] += 1;
        }
    }
}
