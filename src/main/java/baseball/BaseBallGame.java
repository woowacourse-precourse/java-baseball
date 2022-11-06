package baseball;

public class BaseBallGame {

    private final Computer computer;

    public BaseBallGame() {
        this.computer = new Computer();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.generateNumber();
    }
}
