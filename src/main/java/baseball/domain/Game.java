package baseball.domain;

/**
 * 숫자야구 게임을 진행하는 클래스
 */
public class Game {
    private static Computer computer;
    private static User user;

    public Game() { // 테스트용 기본 생성자
    }

    public Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.createRandomNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            user.inputNumber();
            user.validateNumber();

            Hint hint = computer.getHint(user.getNumber());
            String hintMessage = hint.getHintMessage();
            System.out.println(hintMessage);

            if (hint.isAllStrike()) {
                break;
            }
        }
    }

    public void finish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean isStop() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        user.inputNumber();

        user.validateRestart();

        return user.isStop();
    }

}
