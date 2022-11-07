package baseball;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int ON = 1;
    private List<Integer> targetNumber = new ArrayList<>();
    private List<Integer> playerNumber = new ArrayList<>();

    private int gameState = ON;

    void start() { // 게임 실행

    }

    void setTargetNumber(List<Integer> targetNumber) { // 1. 랜덤 숫자 만들기
        targetNumber.clear();
        while (targetNumber.size() < 3) {
            targetNumber.add(makeRandomNumber(targetNumber));
        }
    }

}