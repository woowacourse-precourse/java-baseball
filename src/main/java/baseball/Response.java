package baseball;

public class Response {
    private int strike;
    private int ball;

    public Response() {
        this.strike = 0;
        this.ball = 0;
    }

    public Response(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
}
