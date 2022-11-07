package baseball;

public class Result {
    private int ballCount;
    private int strikeCount;

    public void initialize(){
        ballCount = 0;
        strikeCount = 0;
    }

    public void increaseBallCount(){
        ballCount++;
    }

    public void increaseStrikeCount(){
        strikeCount++;
    }

    public String createResultMessage(){
        String resultMessage = "";

        return resultMessage;
    }
    public boolean isWrongAnswer(){
        return false;
    }
}
