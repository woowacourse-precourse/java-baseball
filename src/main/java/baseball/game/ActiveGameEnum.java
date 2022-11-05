package baseball.game;

public enum ActiveGameEnum {

    START((short)1),
    END((short)2);

    private final short activeGame;

    ActiveGameEnum(short activeGame) {
        this.activeGame = activeGame;
    }
}
