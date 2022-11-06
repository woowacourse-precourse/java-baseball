package baseball;

import java.util.List;

public class Judge {

    static final int GAME_COUNT = 3;

    // TODO "indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다." indent depth 줄여보기
    static int countStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strikeCnt = 0;
        for (int i = 0; i < GAME_COUNT; i++) {
            if (userNumbers.get(i) == computerNumbers.get(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    // TODO "indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다." indent depth 줄여보기
    // TODO Enum 클래스 적용 고민해보기
    static int countBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int ballCnt = 0;
        for (int i = 0; i < GAME_COUNT; i++) {
            if (userNumbers.get(i) == computerNumbers.get((i + 1) % 3)) {
                ballCnt++;
            } else if (userNumbers.get(i) == computerNumbers.get((i + 2) % 3)) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

    // TODO "else 예약어를 쓰지 않았는가?" 객체지향 생활 체조 원칙 적용해보기
    static void getGameScore(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strikeCnt = countStrike(userNumbers, computerNumbers);
        int ballCnt = countBall(userNumbers, computerNumbers);
        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0 && ballCnt != 0) {
            System.out.println(ballCnt + "볼");
        } else if (strikeCnt != 0 && ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else if (strikeCnt != 0 && ballCnt != 0) {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }
}
