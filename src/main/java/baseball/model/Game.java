package baseball.model;

import java.util.List;

public class Game {
    private List<String> numbers;

    public Game() {}

    public Game(List<String> numbers){
        this.numbers = numbers;
    }

    private void validation(){
        // TODO: 검증 로직 정의
    }
}
