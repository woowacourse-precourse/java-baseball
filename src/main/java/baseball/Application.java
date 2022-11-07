package baseball;

public class Application {
    public Computer computer;
    public User user;

    public Application(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        Application application = new Application(computer, user);
        application.computer.pickRandomNumber();
        application.printStartGame();
        application.user.getUserGuessInput();
        System.out.println(application.user.getUserInputList());
    }

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
