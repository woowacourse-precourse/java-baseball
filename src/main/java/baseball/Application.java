package baseball;
import java.util.List;


import static baseball.Game.ball;
import static baseball.Game.strike;
import static baseball.GameStatus.EXIT;
import static baseball.GameStatus.ON;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        run();
    }

    static void run(){
        GameStatus gameStatus = ON;
        while (gameStatus == ON) {
            List<Integer> answer = Computer.pickRandomNumber();
            while (true) {
                    User user = new User();
                    int strike = strike(user.getValues(), answer);
                    int ball = ball(user.getValues(), answer);
                    boolean result = Print.result(ball, strike);
                    if (result) {
                        break;
                    }
            }
            int gameStatusNumber = User.getExitOrRestart();
            if (gameStatusNumber == 2) {
                gameStatus = EXIT;
            }
        }
    }
}
