package baseball;

import java.util.List;

import static baseball.Constants.BALL;
import static baseball.Constants.NOTHING;
import static baseball.Constants.STRIKE;
import static baseball.Constants.CORRECT_ANSWER_MESSAGE;

public class Answer {

    public static boolean isAnswer(List<Integer> randomNumList, List<Integer> inputNumList) {
        // 정답 true, 오답 false와 힌트 출력
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

    // 같은 수가 같은 자리에 있으면 스트라이크
    public static int getStrikeCnt(List<Integer> randomNumList, List<Integer> inputNumList) {
        int strikeCnt = 0;

        for (int i = 0; i < randomNumList.size(); i++) {
            if (randomNumList.get(i) == inputNumList.get(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    // 같은 수가 다른 자리에 있으면 볼
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
