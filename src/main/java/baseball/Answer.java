package baseball;

import java.util.List;

import static baseball.Constants.BALL;
import static baseball.Constants.NOTHING;
import static baseball.Constants.STRIKE;
import static baseball.Constants.CORRECT_ANSWER_MESSAGE;

public class Answer {

    public static boolean isAnswer(List<Integer> randomNumList, List<Integer> inputNumList) {
        return printHint(randomNumList, inputNumList);
    }

    public static boolean printHint(List<Integer> randomNumList, List<Integer> inputNumList) {
        int strikeCnt = getStrikeCnt(randomNumList, inputNumList);
        int ballCnt = getBallCnt(randomNumList, inputNumList);
        boolean answer = false;

        if (strikeCnt == 0 && ballCnt != 0) {
            System.out.println(ballCnt + BALL);
        }

        if (strikeCnt != 0 && ballCnt == 0) {
            System.out.println(strikeCnt + STRIKE);
        }

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println(NOTHING);
        }

        if (strikeCnt != 0 && ballCnt != 0) {
            System.out.println(ballCnt + BALL + " " + strikeCnt + STRIKE);
        }

        if (strikeCnt == 3) {
            System.out.println(CORRECT_ANSWER_MESSAGE);
            answer = true;
        }

        return answer;
    }

    public static int getStrikeCnt(List<Integer> randomNumList, List<Integer> inputNumList) {
        int strikeCnt = 0;

        for (int i = 0; i < randomNumList.size(); i++) {
            if (randomNumList.get(i) == inputNumList.get(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public static int getBallCnt(List<Integer> randomNumList, List<Integer> inputNumList) {
        int ballCnt = 0;

        for (int i = 0; i < randomNumList.size(); i++) {
            if (randomNumList.get(i) != inputNumList.get(i)
                    && inputNumList.contains(randomNumList.get(i))) {
                ballCnt++;
            }
        }
        return ballCnt;
    }
}
