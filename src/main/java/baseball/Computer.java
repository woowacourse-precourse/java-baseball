package baseball;

import java.util.*;

import static baseball.Function.*;
import static baseball.Sentence.*;

public class Computer {

    protected static List<Integer> Answer;
    protected static String result;
    protected static HashMap<String, Integer> HintMap;

    public Computer() {
    }

    public static void resetAll() {
        Answer = new ArrayList<>();
        resetHintMap();
        result = BLANK;
    }

    public static void resetHintMap() {
        HintMap = new HashMap<>();
        HintMap.put(STRIKE, 0);
        HintMap.put(BALL, 0);
    }

    public static void makeAnswer() {
        Answer = new ArrayList<>();
        while (Answer.size() < 3) {
            addRandomNumber(Answer);
        }
    }

    public static void isStrikeOrBall(int AnswerNum, int num) {
        if (AnswerNum == num) {
            HintMap.replace(STRIKE, HintMap.get(STRIKE) + 1);
        } else {
            HintMap.replace(BALL, HintMap.get(BALL) + 1);
        }
    }

    public static void checkPlayerAnswer(int AnswerNum, int num) {
        if (Answer.contains(num)) {
            isStrikeOrBall(AnswerNum, num);
        }
    }

    public static void makeHintMap(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            checkPlayerAnswer(Answer.get(i), list.get(i));
        }
    }

    public static void giveHint() {
        result = HintMap.get(BALL) + BALL + SPACE + HintMap.get(STRIKE) + STRIKE;
        if (HintMap.get(STRIKE) == 0) {
            result = HintMap.get(BALL) + BALL;
        }
        if (HintMap.get(BALL) == 0) {
            result = HintMap.get(STRIKE) + STRIKE;
        }
        if (HintMap.get(STRIKE) == 0 && HintMap.get(BALL) == 0) {
            result = NOTHING;
        }
        System.out.println(result);
    }

    public static boolean is3Strike() {
        if (HintMap.get(STRIKE) == 3) {
            return true;
        }
        return false;
    }

}

