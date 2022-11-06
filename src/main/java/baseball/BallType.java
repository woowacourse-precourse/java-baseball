package baseball;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public enum BallType {
    Strike("스트라이크"),
    Ball("볼"),
    Missing("미싱");

    private final String koren;

    private BallType(String koren){
        this.koren = koren;
    }

    public String getKorean(){
        return koren;
    }
}
