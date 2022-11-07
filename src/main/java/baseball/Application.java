package baseball;

public class Application {
    public Computer computer;

    public Application(Computer computer) {
        this.computer = computer;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Application application = new Application(computer);
        application.computer.pickRandomNumber();
        application.printStartGame();
    }

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
