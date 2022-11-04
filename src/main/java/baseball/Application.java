package baseball;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        GameTextPrinter.printGameStartText();
        application.playGame();
    }

    private void playGame() {
        Computer computer = new Computer();
        computer.generateRandomNumber();
    }
}
