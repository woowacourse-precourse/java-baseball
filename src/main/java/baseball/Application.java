package baseball;

public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();

        baseball.initialize();
        baseball.play();


        System.out.println("게임 종료");
    }
}
