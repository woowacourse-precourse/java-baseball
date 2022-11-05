package baseball;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        user.GameStart();
        computer.printGameResult();
    }
}
