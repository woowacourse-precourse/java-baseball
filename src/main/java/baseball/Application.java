package baseball;

public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();

        do {
            baseball.initialize();
            baseball.play();
        } while (baseball.continueCheck());

        System.out.println("게임 종료");
    }
}
