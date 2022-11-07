package baseball.domain.referee;

public class RefereeImpl implements Referee {

    private final String END_POINT = "3스트라이크";
    private boolean eachSetContext = true;

    @Override
    public boolean isEachSetContext() {
        return eachSetContext;
    }

    @Override
    public void updateEachSetContext(String message) {
        if (message.equals(END_POINT)) {
            eachSetContext = false;
        }
    }

    @Override
    public void clearEachSetContext() {
        eachSetContext = true;
    }
}
