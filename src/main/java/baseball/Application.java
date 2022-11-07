package baseball;

public class Application {

    static User user;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static void baseballGame() {
        Computer computer = new Computer();
        boolean GameOver = false;

        while (!GameOver) {
            user.setInputForAnswer();
            user.checkInputForAnswer();
            String result = computer.getResult(user.input);
            System.out.println(result);
            if (computer.isGameOver(user.input)) {
                GameOver = true;
            }
        }
    }
}
