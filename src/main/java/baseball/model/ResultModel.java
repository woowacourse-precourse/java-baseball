package baseball.model;

enum ResultList {
    Ball("볼"),
    STRIKE("스트라이크"),
    NOTTING("낫싱");

    final private String result;

    ResultList(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}

public class ResultModel {
    private int ballNum;
    private int strikeNum;

    public ResultModel() {
        this.ballNum = 0;
        this.strikeNum = 0;
    }

    public int getBallNum() {
        return ballNum;
    }

    public void setBallNum(int ballNum) {
        this.ballNum = ballNum;
    }

    public int getStrikeNum() {
        return strikeNum;
    }

    public void setStrikeNum(int strikeNum) {
        this.strikeNum = strikeNum;
    }
}
