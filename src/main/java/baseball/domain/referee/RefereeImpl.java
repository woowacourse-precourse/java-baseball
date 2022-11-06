package baseball.domain.referee;

public class RefereeImpl implements Referee {

    private final String END_POINT = "3스트라이크";

    @Override
    public boolean isEndGameSet(String resultMessage) {
        if (!resultMessage.equals(END_POINT)) {
            return false;
        }
        return true;
    }
}
