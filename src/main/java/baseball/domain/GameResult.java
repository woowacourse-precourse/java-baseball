package baseball.domain;

import baseball.view.MessagesForPrint;

public class GameResult {

    private int ballCount;
    private int strikeCount;

    public GameResult() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void increaseBallCount(){
        this.ballCount +=1;
    }
    public void increaseStrikeCount(){
        this.strikeCount +=1;
    }
    public String getResultMessage(){
        StringBuilder sb = new StringBuilder();
        if(ballCount > 0){
            sb.append(ballCount+MessagesForPrint.RESULT_BALL.getMessage()+" ");
        }

        if(strikeCount > 0)
            sb.append(strikeCount+MessagesForPrint.RESULT_STRIKE.getMessage()+" ");

        if(sb.length() == 0)
            sb.append(MessagesForPrint.RESULT_NOTHING.getMessage()+" ");

        return sb.toString().trim();
    }

    public boolean isGameEnd(){

        return strikeCount == 3;
    }
}
