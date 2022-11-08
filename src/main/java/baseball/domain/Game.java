package baseball.domain;

public class Game {

    private Computer computer;
    private User user;

    public Game() {
        this.computer = new Computer();
        this.user = new User();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public Computer getComputer() {
        return this.computer;
    }

    public User getUser() {
        return this.user;
    }
}
