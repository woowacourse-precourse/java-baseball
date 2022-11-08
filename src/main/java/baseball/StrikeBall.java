package baseball;

public class StrikeBall {
    private int strike;
    private int ball;
    String output = "";

    StrikeBall(){
        this(0,0);
    }

    StrikeBall(int strike, int ball){
        this.strike = strike;
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public String toString(){
        if(strike!=0 && ball!=0)
            output = ball+"볼 "+strike+"스트라이크";
        else if(strike!=0)
            output = strike+"스트라이크";
        else if(ball!=0)
            output = ball+"볼";
        else
            output = "낫싱";

        return output;
    }
}
