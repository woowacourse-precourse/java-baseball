package baseball.game;

public class Result {

    private static final String THREE_STRIKE_MESSAGE = "3스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String ETC_MESSAGE = "%d볼 %d스트라이크";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public GameResult getGameResult(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            printThreeStrikeMessage();
            return GameResult.THREE_STRIKE;
        }
        if (strikeCount == 0 && ballCount == 0) {
            printNothingMessage();
            return GameResult.NOTHING;
        }
        printEtcMessage(strikeCount, ballCount);
        return GameResult.ETC;
    }

    private void printThreeStrikeMessage() {
        System.out.println(THREE_STRIKE_MESSAGE);
        System.out.println(GAME_END_MESSAGE);
    }

   private void printNothingMessage() {
       System.out.println(NOTHING_MESSAGE);
   }

   private void printEtcMessage(int strikeCount, int ballCount) {
       System.out.println(String.format(ETC_MESSAGE, ballCount, strikeCount));
   }
}
