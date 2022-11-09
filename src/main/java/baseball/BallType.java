package baseball;

public enum BallType {
    Strike("Strike", "스트라이크"),
    Ball("Ball", "볼"),
    Nothing("Nothing", "낫싱");

    private final String english;
    private final String korean;

    BallType(String english, String korean){
        this.english = english;
        this.korean = korean;
    }

    public String getEnglish(){
        return english;
    }

    public String getKorean(){
        return korean;
    }

}
