package baseball;

import java.util.ArrayList;
import java.util.List;

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
            System.out.println(ballCnt + "볼");
        }

        if (strikeCnt != 0 && ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        }

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        }

        if (strikeCnt != 0 && ballCnt != 0) {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }

        if (strikeCnt == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
