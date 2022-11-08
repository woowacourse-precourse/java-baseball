package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Opponent {

    private static final int MAX_SIZE = 3;

    public static boolean checkRandomNumber(int num, List<Integer> list) {
        return !list.contains(num);
    }

    public static List<Integer> createAnswer() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!checkRandomNumber(randomNumber, list)) {
                continue;
            }
            list.add(randomNumber);
        }
        return list;
    }

    public static Integer getNumber(List<Integer> opponentAnswer, int idx) {
        return opponentAnswer.get(idx);
    }
}