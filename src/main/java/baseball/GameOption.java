package baseball;

public enum GameOption {
    ANSWER_SIZE(3),
    MIN_ANSWER_NUMBER(1),
    MAX_ANSWER_NUMBER(9),
    REPLAY(1),
    EXIT(2);

    private final int option;

    GameOption(int option){
        this.option = option;
    }

    public int option(){
        return option;
    }
}
