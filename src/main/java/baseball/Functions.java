package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.Game.Max_size;
import static baseball.Game.STRIKE;
import static baseball.Game.BALL;

public class Functions {
    public static List<Integer> createTargetNums() {
        List<Integer> targetNums = new ArrayList<>();
        while (targetNums.size() < Max_size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNums.contains(randomNumber)) {
                targetNums.add(randomNumber);
            }
        }

        return targetNums;
    }

    public static List<Integer> stringToIntegerList(String str) {
        List<Integer> newList = new ArrayList<>();
        for (char x : str.toCharArray()) {
            newList.add(Character.getNumericValue(x));
        }
        return newList;
    }

    public static List<Integer> count_BallStrike(List<Integer> targetNums, List<Integer> userNums) {
        int balls = commonNums(targetNums, userNums);
        int strikes = count_strikes(targetNums, userNums);
        balls -= strikes;

        List<Integer> b_s_list = Arrays.asList(balls,strikes);
        return b_s_list;
    }

    public static boolean isFullhit(List<Integer> ball_Strike) {
        if (ball_Strike.get(STRIKE) == Max_size) return true;
        return false;
    }

    public static void printResult(List<Integer> ball_Strike) {
        int ball = ball_Strike.get(BALL);
        int strike = ball_Strike.get(STRIKE);
        String print = "";
        if (ball != 0) {
            print += ball;
            print += "볼 ";
        }
        if (strike != 0) {
            print += strike;
            print += "스트라이크";
        }
        if (ball == 0 && strike == 0)
            print = "낫싱";
        System.out.println(print);
    }

    private static int commonNums(List<Integer> list1, List<Integer> list2) {
        ArrayList<Integer> list3 = new ArrayList<>(list1);
        list3.retainAll(list2);
        return list3.size();
    }

    private static int count_strikes(List<Integer> targetNums, List<Integer> userNums) {
        int strike = 0;
        for (int index = 0; index < targetNums.size(); index++) {
            if (targetNums.get(index) == userNums.get(index))
                strike++;
        }
        return strike;
    }
}
