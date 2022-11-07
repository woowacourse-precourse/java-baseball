package baseball.util;

public enum BallCode {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String code;

    BallCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }
}
