package baseball;

public class Game {

    public static final int DEFAULT_LEN = 3;
    private int maxLen;

    public Game(){
        this(DEFAULT_LEN);
    }

    public Game(int maxLen){
        this.maxLen = maxLen;
    }



}
