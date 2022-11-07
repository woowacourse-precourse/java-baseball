package baseball;

import utils.InputUtils;

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
        int ballValue = this.hint.get(BALL);
        if (ballValue > 0) {
            isSameNum = true;
            hintToPlayer.add(ballValue + BALL);
        }

        int strikeValue = this.hint.get(STRIKE);
        if (strikeValue > 0) {
            isSameNum = true;
            hintToPlayer.add(strikeValue + STRIKE);
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
                this.hint.put(STRIKE, this.hint.get(STRIKE) + 1);
                continue;
            }
            if (this.baseballNumber.contains(playerNum)) {
                this.hint.put(BALL, this.hint.get(BALL) + 1);
                continue;
            }
            this.hint.put(NOTHING, this.hint.get(NOTHING) + 1);
        }
    }

    public void setHintDefault() {
        this.hint.replaceAll((key, value) -> value = 0);
    }

    public void setBaseballNumber() {
        Set<Integer> checkValidNumber = new HashSet<>();
        Random random = new Random();

        while (checkValidNumber.size() != 3) {
            int randomNum = random.nextInt(9) + 1;
            checkValidNumber.add(randomNum);
        }

        this.baseballNumber = new ArrayList<>(checkValidNumber);
    }
}
