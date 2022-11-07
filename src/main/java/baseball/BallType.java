package baseball;

public enum BallType {
    Strike("스트라이크"),
    Ball("볼"),
    Missing("미싱");

    private final String koren;

    BallType(String koren){
        this.koren = koren;
    }

    public String getKorean(){
        return koren;
    }

}
