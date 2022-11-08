package baseball;

import java.util.Arrays;

/**
 * 게임 종료 후 선택지 목록 정의한 enum
 */
public enum IntentionOfContinuingGame {
    CONTINUE(1, true), STOP(2, false);
    private final int intention;
    private final boolean wantContinue;

    IntentionOfContinuingGame(int intention, boolean wantContinue) {
        this.intention = intention;
        this.wantContinue = wantContinue;
    }

    /**
     * @param userIntention
     * @return 1을 입력한 경우 CONTINUE, 2를 입력한 경우 STOP enum 객체를 반환
     * @throws IllegalArgumentException 유효하지 않은 값이 입력되는 경우 반환
     */
    public static IntentionOfContinuingGame getMatchIntention(int userIntention) throws IllegalArgumentException{
        try {
            return Arrays.stream(IntentionOfContinuingGame.values())
                .filter((intention) -> (intention.intention == userIntention)).findAny().get();
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 선택지를 입력하였습니다.");
        }
    }

    public boolean wantContinue() {
        return this.wantContinue;
    }
}
