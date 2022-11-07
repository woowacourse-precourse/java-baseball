package baseball;

public class BallAndStrike {
    private int ball;
    private int strike;

    BallAndStrike() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getBall(){
        return this.ball;
    }

    public int getStrike(){
        return this.strike;
    }

    public void setStrike(int strike){
        this.strike = strike;
    }
    public void setBall(int ball){
        this.ball = ball;
    }

    public void print() {
        if(this.ball == 0 && this.strike == 0 ) System.out.println("낫싱");
        else if (this.ball == 0 || this.strike == 0) {
            if (this.ball == 0) {
                System.out.println(this.strike + "스트라이크");
            }
            else {
                System.out.println(this.ball + "볼");
            }
        }
        else {
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
        }
    }
}
