package baseball;

import java.util.*;

public class GameHost extends BaseballNumber {
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private final Map<String, Integer> hint = new HashMap<>() {{
        put(STRIKE, 0);
        put(BALL, 0);
        put(NOTHING, 0);
    }};

    public GameHost() {
        setBaseballNumber();
    }

    public String getHint() {
        StringJoiner hintToPlayer = new StringJoiner(" ");
        boolean isSameNum = false;
        if (getBallScore() > 0) {
            isSameNum = true;
            hintToPlayer.add(getBallScore() + BALL);
        }

        if (getStrikeScore() > 0) {
            isSameNum = true;
            hintToPlayer.add(getStrikeScore() + STRIKE);
        }

        if (isSameNum) {
            return hintToPlayer.toString();
        }

        return NOTHING;
    }

    public void setHint(List<Integer> playerNumber) {
        setHintDefault();
        for (int i = 0; i < playerNumber.size(); i++) {
            int playerNum = playerNumber.get(i);
            int baseballNum = this.baseballNumber.get(i);

            if (playerNum == baseballNum) {
                setStrikeScore();
                continue;
            }
            if (this.baseballNumber.contains(playerNum)) {
                setBallScore();
                continue;
            }
            setNothingScore();
        }
    }

    public void setHintDefault() {
        hint.replaceAll((key, value) -> value = 0);
    }

    private void setStrikeScore() {
        hint.put(STRIKE, hint.get(STRIKE) + 1);
    }

    private void setBallScore() {
        hint.put(BALL, hint.get(BALL) + 1);
    }

    private void setNothingScore() {
        hint.put(NOTHING, hint.get(NOTHING) + 1);
    }

    private Integer getStrikeScore() {
        return hint.get(STRIKE);
    }

    private Integer getBallScore() {
        return hint.get(BALL);
    }

    public void setBaseballNumber() {
        Set<Integer> checkValidNumber = new HashSet<>();
        Random random = new Random();
        final int BASEBALL_LENGTH = 3;

        while (checkValidNumber.size() != BASEBALL_LENGTH) {
            int randomNum = random.nextInt(9) + 1;
            checkValidNumber.add(randomNum);
        }

        this.baseballNumber = new ArrayList<>(checkValidNumber);
    }
}
