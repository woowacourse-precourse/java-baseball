package baseball;

public class Game {
    private final String openingPhrase = "숫자 야구 게임을 시작합니다.";

    public Game() {
        ComputerNums computerNums = new ComputerNums();
    }


    public String opening() {
        return openingPhrase;
    }

    public void doGame() {

    }
}
