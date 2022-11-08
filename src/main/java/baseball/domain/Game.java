package baseball.domain;

/**
 * 숫자야구 게임을 진행하는 클래스
 */
public class Game {
    private static Computer computer;

    public Game(Computer computer) {
        this.computer = computer;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.createRandomNumber();
    }

}
