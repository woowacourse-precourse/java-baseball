package baseball;

public enum HintInfo {

    NOTHING("낫싱", 0,0),
    THREESTRIKE("3스트라이크", 3, 0),
    TWOSTRIKE("2스트라이크",2,0),
    ONESTRIKE("1스트라이크",1,0),
    ONESTRIKEONEBALL("1볼 1스트라이크",1,1),
    ONESTRIKETWOBALL("2볼 1스트라이크",1,2),
    ONEBALL("1볼",0,1),
    TWOBALL("2볼",0,2),
    THREEBALL("3볼", 0, 3);


    private final String title;
    private final int strikeCount;
    private final int ballCount;

    HintInfo(String title, int strikeCount, int ballCount) {
        this.title = title;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public String getTitle(){
        return this.title;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void print(int strikeCount, int ballCount){
    }
}
