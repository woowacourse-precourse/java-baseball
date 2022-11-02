package baseball;

import java.util.List;

public class Output {
    public static void showGuessResult(List<Integer> result) {
        if (result.size() != 2) {
            throw new IllegalStateException("result는 2가 아닌 다른 값이 나올 수 없습니다(strike, ball)");
        }
        Integer strikeCnt = result.get(0);
        Integer ballCnt = result.get(1);
        String sentence = makeSentenceAboutGuessResult(strikeCnt, ballCnt);
        System.out.println(sentence);
    }

    private static String makeSentenceAboutGuessResult(Integer strikeCnt, Integer ballCnt) {
        String sentence = "";
        if (ballCnt != 0) {
            sentence += (ballCnt + "볼");
        }
        if (strikeCnt != 0) {
            if (!sentence.equals("")) {
                sentence += " ";
            }
            sentence += (strikeCnt + "스트라이크");
        }
        return sentence;
    }

    public static void showGameCompleteMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
