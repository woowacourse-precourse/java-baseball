package baseball;

import baseball.domain.Result;

public class Output {
    public static void showGuessResult(Result result) {
        String sentence = makeSentenceAboutGuessResult(result.getStrikeCnt(), result.getBallCnt());
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
        if (ballCnt == 0 && strikeCnt == 0) {
            sentence += "낫싱";
        }
        return sentence;
    }

    public static void showGameCompleteMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
