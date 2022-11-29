package baseball.service;

public enum GameSetting {

    START_NUMBER(1),
    END_NUMBER(9),
    NUMBER_LENGTH(3),
    GAME_END_CONDITION(3);

    private final int attribute;

    GameSetting(int attribute) {
        this.attribute = attribute;
    }

    public int getAttribute() {
        return attribute;
    }

}
