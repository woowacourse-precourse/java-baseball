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

        if(ballCount==0 && strikeCount==0){
            resultMessage = Settings.NOTHING;
        }else if(ballCount>0){
            resultMessage = ballCount + Settings.BALL;
        }else if(strikeCount>0){
            resultMessage = strikeCount + Settings.STRIKE;
        }else{
            resultMessage = ballCount + Settings.BALL + strikeCount + Settings.STRIKE;
        }

        return resultMessage;
    }
    public boolean isWrongAnswer(){
        return strikeCount < 3;
    }
}
