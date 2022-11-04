package baseball;

public class GameView {

    public void printStart() {
        System.out.println(ConstGame.START);
    }

    public void printInput() {
        System.out.print(ConstGame.INPUT);
    }

    public void printHint(Integer ball, Integer strike) {
        if (strike == 0 && ball == 0) {
            System.out.print(ConstGame.NOTHING);
            return;
        }
        if (ball > 0) {
            System.out.printf("%d%s ", ball, ConstGame.BALL);
        }
        if (strike > 0) {
            System.out.printf("%d%s", strike, ConstGame.STRIKE);
        }
        System.out.print("\n");
    }

    public void printRestart() {
        System.out.print(ConstGame.RESTART);
    }
}
