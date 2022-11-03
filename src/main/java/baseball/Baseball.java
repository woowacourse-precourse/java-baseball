package baseball;

public class Baseball {
    private BaseballInput baseballInput;
    private BaseballOutput baseballOutput;
    private BaseballResult baseballResult;
    private BaseballScore baseballScore;


    Baseball() {
        baseballInput = new BaseballInput();
        baseballOutput = new BaseballOutput();
        baseballResult = new BaseballResult();
        baseballScore = new BaseballScore();
    }

    public void play() throws IllegalArgumentException {
    }


}
