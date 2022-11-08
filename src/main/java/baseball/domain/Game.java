package baseball.domain;

/**
 * 숫자야구 게임을 진행하는 클래스
 */
public class Game {
    private static Computer computer;
    private static User user;

    public Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.createRandomNumber();

        System.out.print("숫자를 입력해주세요 : ");
        user.inputNumber();
    }

}
