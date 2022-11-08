package baseball;

public class GameResult {
    private int ballCnt;
    private int strikeCnt;

    public GameResult(int ballCnt, int strikeCnt){
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
    }

    public boolean isAllStrike(){
        return strikeCnt == Game.ANSWER_SIZE;
    }

    @Override
    public String toString(){
        if((strikeCnt > 0) && (ballCnt > 0)){
            return ballCnt + "볼 " + strikeCnt + "스트라이크";
        } else if(ballCnt > 0){
            return ballCnt + "볼";
        } else if(strikeCnt > 0){
            return strikeCnt + "스트라이크";
        }

        return "낫싱";
    }
}
