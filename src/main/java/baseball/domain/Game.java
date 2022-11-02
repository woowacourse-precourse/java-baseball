package baseball.domain;

public class Game {
    private static String START_GAME = "숫자 야구 게임을 시작합니다.";
    User user;
    Computer computer;
    public Game(){
        this.user = new User();
        this.computer = new Computer();
    }
    public void Start() {
        while (true) {
            computer.createRandomNumbers();
            System.out.println(START_GAME);
            user.inputUserNumbers();
        }
    }
}
