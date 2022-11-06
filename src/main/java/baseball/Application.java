package baseball;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = Settings.makeNumber();
        ArrayList<Integer> user = Settings.userNumber();

        int strikeCounter = Game.strike(user, computer);
        int ballCounter = Game.ball(user, computer);
        boolean nothingTrue = Game.nothing(strikeCounter, ballCounter);

        System.out.println(computer);
        System.out.println(user);
        System.out.println(strikeCounter);
        System.out.println(ballCounter);
        System.out.println(nothingTrue);
    }
}
