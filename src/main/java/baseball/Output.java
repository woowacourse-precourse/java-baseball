package baseball;

public class Output {
    public static void showGuessResult(Integer strikeCnt, Integer ballCnt) {
        String sentence = "";
        if (ballCnt != 0) {
            sentence += (String.valueOf(ballCnt) + "볼");
        }
        if (strikeCnt != 0) {
            if (!sentence.equals("")) {
                sentence += " ";
            }
            sentence += (String.valueOf(strikeCnt) + "스트라이크");
        }
        System.out.println(sentence);
    }

    public static void showGameCompleteMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
